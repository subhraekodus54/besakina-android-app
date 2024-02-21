package com.example.besakina.ui.activity

import android.content.Intent
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

        binding.doctorLay.setOnClickListener {
            val intent = Intent(this, DoctorsFormActivity::class.java)
            startActivity(intent)
        }

        binding.hospitalLay.setOnClickListener {
            val intent = Intent(this, ClinicFormActivity::class.java)
            startActivity(intent)
        }
    }
}