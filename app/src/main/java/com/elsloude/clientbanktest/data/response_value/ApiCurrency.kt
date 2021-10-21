package com.elsloude.clientbanktest.data.response_value

import com.elsloude.clientbanktest.data.Constants
import com.elsloude.clientbanktest.data.response_value.pojo.CurrencyResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiCurrency {
    @GET("/daily_json.js")
    suspend fun getCurrency(): Response<CurrencyResponse>

    companion object {
        operator fun invoke(): ApiCurrency {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_CURRENCY)
                .addConverterFactory(GsonConverterFactory.create())
                .client(Constants.client)
                .build()
                .create(ApiCurrency::class.java)
        }
    }
}