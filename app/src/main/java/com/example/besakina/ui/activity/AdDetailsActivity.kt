package com.example.besakina.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denzcoskun.imageslider.models.SlideModel
import com.example.besakina.R
import com.example.besakina.databinding.ActivityAdDetailsBinding
import com.example.besakina.databinding.ActivitySplashBinding

class AdDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAdDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel("https://images.unsplash.com/photo-1511919884226-fd3cad34687c?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        imageList.add(SlideModel("https://images.unsplash.com/photo-1502877338535-766e1452684a?q=80&w=1472&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        imageList.add(SlideModel("https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        binding.imageSlider.setImageList(imageList)

        binding.backArrow.setOnClickListener {
            finish()
        }
    }
}