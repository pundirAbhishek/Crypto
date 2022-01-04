package com.example.crypto.data.api

import com.example.crypto.network.CommonHeadersAppenderInterceptor
import com.example.crypto.network.UrlConfig
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit {

    private const val timeOut = 20L

    private val commonHeadersAppenderInterceptor: CommonHeadersAppenderInterceptor by lazy(
        LazyThreadSafetyMode.NONE
    ) {
        CommonHeadersAppenderInterceptor()
    }

    private val okHttpClient by lazy {
        OkHttpClient.Builder().apply {
            readTimeout(timeOut, TimeUnit.SECONDS)
            connectTimeout(timeOut, TimeUnit.SECONDS)
            addInterceptor(commonHeadersAppenderInterceptor)
        }.build()
    }


    //TODO : Add Common Convertor Factory
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(UrlConfig.cryptoBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}