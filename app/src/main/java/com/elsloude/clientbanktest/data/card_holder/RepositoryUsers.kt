package com.elsloude.clientbanktest.data.card_holder

import android.app.Application
import androidx.lifecycle.LiveData
import com.elsloude.clientbanktest.data.AppDatabase
import com.elsloude.clientbanktest.data.card_holder.pojo.User

class RepositoryUsers(val api: ApiPlaceholder) {
    suspend fun getUsers() = api.getUsers()


}