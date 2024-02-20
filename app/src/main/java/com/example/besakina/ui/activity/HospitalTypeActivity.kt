package com.example.besakina.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.besakina.R
import com.example.besakina.databinding.ActivityHospitalTypeBinding
import com.example.besakina.databinding.ActivityHospitalityFormBinding

class HospitalTypeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHospitalTypeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHospitalTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backArrow.setOnClickListener {
            finish()
        }
    }
}