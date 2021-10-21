package com.elsloude.clientbanktest.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.elsloude.clientbanktest.R
import com.elsloude.clientbanktest.data.card_holder.ApiPlaceholder
import com.elsloude.clientbanktest.data.card_holder.ModelFactory
import com.elsloude.clientbanktest.data.card_holder.RepositoryUsers
import com.elsloude.clientbanktest.data.response_value.ApiCurrency
import com.elsloude.clientbanktest.data.response_value.ModelCurrencyFactory
import com.elsloude.clientbanktest.data.response_value.RepositoryCurrency
import com.elsloude.clientbanktest.databinding.FragmentChangeCardBinding
import com.elsloude.clientbanktest.databinding.FragmentMainBinding

class ChangeCardFragment : Fragment() {

    private lateinit var viewModel: ViewModelCurrency
    private var _binding: FragmentChangeCardBinding? = null
    private val binding: FragmentChangeCardBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChangeCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViewModel()
        getCurrency()
    }

    private fun setUpViewModel() {
        val api = ApiCurrency()
        val repository = RepositoryCurrency(api)
        val factory = ModelCurrencyFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(ViewModelCurrency::class.java)
    }

    private fun getCurrency(){
        viewModel.getValute()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}