package com.example.davidmartins.codewar.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor(apiKey: String) : Interceptor {

    companion object {
        private const val API_KEY_QUERY = "access_key"
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()

        val url = request.url().newBuilder().addQueryParameter(API_KEY_QUERY, "").build()

        request = request.newBuilder().url(url).build()

        return chain.proceed(request)

    }
}