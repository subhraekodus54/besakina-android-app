package com.example.besakina.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.besakina.MainActivity
import com.example.besakina.R
import com.example.besakina.databinding.ActivityMainBinding
import com.example.besakina.databinding.ActivitySplashBinding
import com.example.besakina.utils.isConnectedToInternet

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkInternet()
    }

    private fun checkInternet(){
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            finish() }, 3000)
    }

}