package com.baltajmn.auth.di

import com.baltajmn.news.core.auth.BuildConfig
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val AuthModule: Module
    get() = module {
        single(named("FirebaseOptions")) {
            FirebaseOptions.Builder()
                .setProjectId(BuildConfig.PROJECT_ID)
                .setApplicationId(BuildConfig.APP_ID)
                .setApiKey(BuildConfig.API_KEY)
                .build()
        }

        single(named("FirebaseApp")) {
            FirebaseApp.initializeApp(
                androidContext(),
                get(named("FirebaseOptions")),
                "Template"
            )
        }

        single { FirebaseAuth.getInstance() }
    }


