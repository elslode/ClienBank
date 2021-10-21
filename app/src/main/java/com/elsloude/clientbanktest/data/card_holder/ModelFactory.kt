package com.elsloude.clientbanktest.data.card_holder

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.elsloude.clientbanktest.presentation.ViewModelPlaceholder
import java.lang.IllegalArgumentException

class ModelFactory(private val application: Application, private val repo: RepositoryUsers): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelPlaceholder::class.java)) {
            return ViewModelPlaceholder(application, repo) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}