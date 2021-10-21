package com.elsloude.clientbanktest.data.card_holder.pojo

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class TransactionHistory(
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String,
    @ColumnInfo(name = "icon_url")
    @SerializedName("icon_url")
    val iconUrl: String,
    @ColumnInfo(name = "date")
    @SerializedName("date")
    val date: String,
    @ColumnInfo(name = "amount")
    @SerializedName("amount")
    val amount: String
)
