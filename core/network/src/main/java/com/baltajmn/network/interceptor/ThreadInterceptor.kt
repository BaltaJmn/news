package com.baltajmn.network.interceptor

import android.os.Looper
import com.baltajmn.network.exception.NetworkOnMainException
import okhttp3.Interceptor
import okhttp3.Response

class ThreadInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (Looper.getMainLooper().isCurrentThread)
            throw NetworkOnMainException(url = chain.request().url.toString())
        return chain.proceed(chain.request())
    }

}