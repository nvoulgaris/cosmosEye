package com.nvoulgaris.cosmoseye.application

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ApiKeyInterceptor @Inject constructor(): Interceptor {

    private val API_KEY_NAME = "api_key"
    private val API_KEY_VALUE = "mcvyC2Km5OjzF7EE73Cy6YMgteXu0eGcFwNDOO8R"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url().newBuilder().addQueryParameter(API_KEY_NAME, API_KEY_VALUE).build()
        val requestWithApiKey = request.newBuilder().url(url).build()
        return chain.proceed(requestWithApiKey)
    }
}
