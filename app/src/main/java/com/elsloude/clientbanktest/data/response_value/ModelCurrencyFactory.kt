package com.elsloude.clientbanktest.data.response_value

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.elsloude.clientbanktest.data.card_holder.RepositoryUsers
import com.elsloude.clientbanktest.presentation.ViewModelCurrency
import com.elsloude.clientbanktest.presentation.ViewModelPlaceholder
import java.lang.IllegalArgumentException

class ModelCurrencyFactory(private val repo: RepositoryCurrency): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelCurrency::class.java)) {
            return ViewModelCurrency(repo) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}