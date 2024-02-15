package com.example.besakina.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.besakina.MainActivity
import com.example.besakina.R
import com.example.besakina.databinding.ActivityAuthBinding
import com.example.besakina.databinding.ActivitySetLocationBinding
class SetLocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySetLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySetLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.setLocBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.setManuallyBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}