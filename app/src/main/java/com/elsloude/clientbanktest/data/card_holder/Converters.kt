package com.elsloude.clientbanktest.data.card_holder

import androidx.room.TypeConverter
import com.elsloude.clientbanktest.data.card_holder.pojo.TransactionHistory
import com.elsloude.clientbanktest.data.card_holder.pojo.User
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {
    @TypeConverter
    fun fromString(value: String?): List<TransactionHistory>? {
        val listType: Type = object : TypeToken<List<TransactionHistory?>?>() {}.type
        return Gson().fromJson<List<TransactionHistory>>(value, listType)
    }

    @TypeConverter
    fun listToString(list: List<TransactionHistory?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromStringUser(value: String?): List<User>? {
        val listType: Type = object : TypeToken<List<TransactionHistory?>?>() {}.type
        return Gson().fromJson<List<User>>(value, listType)
    }

    @TypeConverter
    fun listToStringUser(list: List<User?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}