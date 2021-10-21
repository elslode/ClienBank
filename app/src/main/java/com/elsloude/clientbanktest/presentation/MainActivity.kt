package com.elsloude.clientbanktest.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elsloude.clientbanktest.R
import com.elsloude.clientbanktest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.main_container, MainFragment()).commit()
    }


}