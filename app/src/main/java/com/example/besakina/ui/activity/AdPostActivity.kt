package com.example.besakina.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.besakina.R
import com.example.besakina.databinding.ActivityAdPostBinding
import com.example.besakina.databinding.ActivityAuthBinding
import com.example.besakina.databinding.ActivityMainBinding

class AdPostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAdPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}