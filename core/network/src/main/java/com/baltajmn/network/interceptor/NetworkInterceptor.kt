package com.baltajmn.network.interceptor

import com.baltajmn.news.core.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class NetworkInterceptor : Interceptor {

    companion object {
        private const val TOKEN_HEADER_KEY = "Authorization"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(requestWithAccessToken(request))
    }

    private fun requestWithAccessToken(request: Request): Request =
        request.newBuilder()
            .addHeader(TOKEN_HEADER_KEY, BuildConfig.API_SECRET)
            .url(request.url)
            .build()

}