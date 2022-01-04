package com.example.crypto.network

import com.example.crypto.BuildConfig
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class CommonHeadersAppenderInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        val builder = request.headers().newBuilder()
        val headers: Headers = builder.add("User-Agent", "Android")
            .add("API-APP-VERSION", BuildConfig.VERSION_CODE.toString())
            .build()
        request = request.newBuilder()
            .headers(headers)
            .build()
        return chain.proceed(request)
    }
}