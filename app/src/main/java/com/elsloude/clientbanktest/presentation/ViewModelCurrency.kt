package com.elsloude.clientbanktest.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elsloude.clientbanktest.data.Resource
import com.elsloude.clientbanktest.data.response_value.RepositoryCurrency
import com.elsloude.clientbanktest.data.response_value.pojo.CurrencyResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ViewModelCurrency(private val repository: RepositoryCurrency): ViewModel() {

    val valute = MutableLiveData<Resource<CurrencyResponse>>()

    fun getValute(){
        CoroutineScope(Dispatchers.Default).launch {
            valute.postValue(Resource.loading(null))
            try {
                val datSign = async { repository.getCurrency() }
                val valute_value = datSign.await().body()
                valute.postValue(Resource.success(valute_value))
                Log.d("getValute", "getUsers: $valute_value")
            } catch (e: Exception) {
                valute.postValue(Resource.error("Sorry, data is not available", null))
            }
        }
    }
}