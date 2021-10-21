package com.elsloude.clientbanktest.data.card_holder

import com.elsloude.clientbanktest.data.Constants
import com.elsloude.clientbanktest.data.card_holder.pojo.CardsPlaceholderResponce
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiPlaceholder {

    @GET("/test/android/v1/users.json")
    suspend fun getUsers(): Response<CardsPlaceholderResponce>

    companion object {
        operator fun invoke(): ApiPlaceholder {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_USERS)
                .addConverterFactory(GsonConverterFactory.create())
                .client(Constants.client)
                .build()
                .create(ApiPlaceholder::class.java)
        }
    }
}