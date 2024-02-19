package com.example.besakina.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.besakina.R
import com.example.besakina.databinding.ActivityAdPostBinding
import com.example.besakina.databinding.ActivityEducationFormBinding

class EducationFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEducationFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEducationFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}