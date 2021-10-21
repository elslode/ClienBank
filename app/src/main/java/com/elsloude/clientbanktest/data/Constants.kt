package com.elsloude.clientbanktest.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class Constants {

    companion object {
        const val BASE_URL_USERS = "https://hr.peterpartner.net"
        const val BASE_URL_CURRENCY = "https://www.cbr-xml-daily.ru"

        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val client: OkHttpClient = OkHttpClient
            .Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }
}