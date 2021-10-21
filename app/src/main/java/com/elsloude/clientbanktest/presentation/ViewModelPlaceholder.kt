package com.elsloude.clientbanktest.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.elsloude.clientbanktest.data.AppDatabase
import com.elsloude.clientbanktest.data.card_holder.RepositoryUsers
import com.elsloude.clientbanktest.data.card_holder.pojo.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ViewModelPlaceholder(application: Application, private val repository: RepositoryUsers) : AndroidViewModel(application) {
    private lateinit var user: User
    val db = AppDatabase.getInstance(application)
    val userList = db.userDao().getCardsList()

    fun setCheckedTrue(cardNumber: String){
        user = db.userDao().getUser(cardNumber)
        user.isChecked = true
        db.userDao().save(user)
    }

    fun setCheckedFalse(cardNumber: String){
        user = db.userDao().getUser(cardNumber)
        user.isChecked = false
        db.userDao().save(user)
    }

    fun getUsers() {
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val datSign = async {
                    repository.getUsers()
                }
                val user = datSign.await().body()
                Log.d("userIt", "getUsers: $user")
                val userList = user?.users
                db.userDao().insertUsersList(userList!!)
            } catch (e: Exception) {
            }
        }
    }
}