package com.baltajmn.network.di

import com.baltajmn.network.client.HttpClient
import com.baltajmn.network.datasource.DefaultNewsDatasource
import com.baltajmn.network.datasource.NewsDatasource
import com.baltajmn.network.interceptor.NetworkInterceptor
import com.baltajmn.network.interceptor.ThreadInterceptor
import com.baltajmn.network.service.NewsService
import okhttp3.Interceptor
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

private const val BASE_URL: String = "https://newsapi.org/"

val NetworkModule = module {

    factoryOf(::NetworkInterceptor) bind Interceptor::class
    factoryOf(::ThreadInterceptor) bind Interceptor::class

    singleOf(::DefaultNewsDatasource) bind NewsDatasource::class

    single(named("UserClient")) {
        HttpClient.getClient(
            baseUrl = BASE_URL,
            interceptors = listOf(
                get<ThreadInterceptor>(),
                get<NetworkInterceptor>()
            ),
        )
    }

    single { NewsService(get(named("UserClient"))) }

}
