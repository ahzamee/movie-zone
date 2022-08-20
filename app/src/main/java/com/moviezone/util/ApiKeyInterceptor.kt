package com.moviezone.util

import com.moviezone.BuildConfig.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val currentUrl = chain.request().url()
        val newUrl = currentUrl.newBuilder().addQueryParameter("apikey", API_KEY).build()
        val currentRequest = chain.request().newBuilder()
        val newRequest = currentRequest.url(newUrl).build()
        return chain.proceed(newRequest)
    }
}
