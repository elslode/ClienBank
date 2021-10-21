package com.elsloude.clientbanktest.data.response_value.pojo

import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("GBP")
    val gbp: CurrencyFullData,
    @SerializedName("USD")
    val usd: CurrencyFullData,
    @SerializedName("EUR")
    val eur: CurrencyFullData
)
