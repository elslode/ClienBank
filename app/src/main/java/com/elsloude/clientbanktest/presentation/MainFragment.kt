package com.elsloude.clientbanktest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.elsloude.clientbanktest.R
import com.elsloude.clientbanktest.data.card_holder.ApiPlaceholder
import com.elsloude.clientbanktest.data.card_holder.ModelFactory
import com.elsloude.clientbanktest.data.card_holder.RepositoryUsers
import com.elsloude.clientbanktest.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var viewModel: ViewModelPlaceholder
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViewModel()
        getUsers()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.creditCard.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_container, ChangeCardFragment()).addToBackStack(null).commit()
        }
        setUserCard()
    }

    private fun getUsers() {
        viewModel.getUsers()
    }

    fun setUserCard() {
        viewModel.userList.observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                val users = it[1]
                binding.cardNumber.text = users.cardNumber
                binding.dataValid.text = users.valid
                binding.nameOfCard.text = users.cardholderName
                binding.balanceAll.text = users.balance.toString()
                if (users.type == "mastercard") {
                    binding.ivProviderCard.setImageResource(R.drawable.ic_mastercard)
                }
                if (users.type == "visa") {
                    binding.ivProviderCard.setImageResource(R.drawable.ic_vasa)
                }
                if (users.type == "unionpay") {
                    binding.ivProviderCard.setImageResource(R.drawable.ic_unionpay)
                }
            }
        })
    }

    private fun setUpViewModel() {
        val api = ApiPlaceholder()
        val repository = RepositoryUsers(api)
        val factory = ModelFactory(requireActivity().application, repository)
        viewModel = ViewModelProvider(this, factory).get(ViewModelPlaceholder::class.java)
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}