package com.elsloude.clientbanktest.data.card_holder.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.elsloude.clientbanktest.data.card_holder.Converters
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cards_user")
data class User(
    var isChecked: Boolean,
    @PrimaryKey
    @SerializedName("card_number")
    val cardNumber: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("cardholder_name")
    val cardholderName: String ,
    @SerializedName("valid")
    val valid: String,
    @SerializedName("balance")
    val balance: Double,
    @TypeConverters(Converters::class)
    @SerializedName("transaction_history")
    val transactionHistory: List<TransactionHistory>
)
