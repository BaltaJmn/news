package com.baltajmn.data.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.ExistingWorkPolicy
import androidx.work.ForegroundInfo
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.baltajmn.data.repository.NewsRepository
import com.baltajmn.news.core.common.R.drawable.fame_new
import com.baltajmn.news.core.data.R
import com.baltajmn.template.core.common.dispatchers.DispatcherProvider
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SyncWorker(
    appContext: Context,
    parameters: WorkerParameters
) : CoroutineWorker(appContext, parameters), KoinComponent {

    private val dispatcherProvider: DispatcherProvider by inject()
    private val newsRepository: NewsRepository by inject()

    override suspend fun doWork(): Result = withContext(dispatcherProvider.background) {

        val syncedSuccessfully = awaitAll(
            async { newsRepository.sync() },
        ).all { it.isSuccess }

        if (syncedSuccessfully) {
            Result.success()
        } else {
            Result.retry()
        }

    }

    companion object {
        fun startUpSyncWork() = OneTimeWorkRequestBuilder<SyncWorker>()
            .setConstraints(SyncConstraints)
            .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            .build()
    }

}

object Sync {
    fun initialize(context: Context) {
        WorkManager
            .getInstance(context)
            .enqueueUniqueWork(
                SyncWorkName,
                ExistingWorkPolicy.KEEP,
                SyncWorker.startUpSyncWork(),
            )
    }
}

internal const val SyncWorkName = "SyncWorkName"

val SyncConstraints
    get() = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .build()

