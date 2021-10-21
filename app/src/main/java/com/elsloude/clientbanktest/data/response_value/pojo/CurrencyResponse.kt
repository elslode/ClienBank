package com.elsloude.clientbanktest.data.response_value.pojo

import com.google.gson.annotations.SerializedName

data class CurrencyResponse(
    @SerializedName("Valute")
    private val currency: Currency
)
