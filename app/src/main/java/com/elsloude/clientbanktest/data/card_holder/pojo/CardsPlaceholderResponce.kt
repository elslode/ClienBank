package com.elsloude.clientbanktest.data.card_holder.pojo


import com.google.gson.annotations.SerializedName

data class CardsPlaceholderResponce(
    @SerializedName("users")
    val users: List<User>
)
