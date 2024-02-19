package com.example.besakina.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.besakina.R
import com.example.besakina.databinding.ActivityAdPostBinding
import com.example.besakina.databinding.ActivityEducationFormBinding
import com.example.besakina.databinding.ActivityHospitalityFormBinding

class HospitalityFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHospitalityFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHospitalityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}