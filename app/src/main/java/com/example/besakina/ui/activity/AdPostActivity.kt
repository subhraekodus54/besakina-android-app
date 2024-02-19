package com.example.besakina.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.besakina.R
import com.example.besakina.adapter.HomeCategoriesAdapter
import com.example.besakina.databinding.ActivityAdPostBinding
import com.example.besakina.databinding.ActivityAuthBinding
import com.example.besakina.databinding.ActivityMainBinding
import com.example.besakina.model.HomeCategoriesModel
import com.example.besakina.utils.ClickListener

class AdPostActivity : AppCompatActivity(), ClickListener {
    private lateinit var binding: ActivityAdPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAdPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listOne: ArrayList<HomeCategoriesModel> = ArrayList()
        listOne.add(HomeCategoriesModel("properties", "Properties"))
        listOne.add(HomeCategoriesModel("vehicle", "Vehicle"))
        listOne.add(HomeCategoriesModel("health_and_wellness", "Health"))
        listOne.add(HomeCategoriesModel("hospitality_travel_tourism", "Hospitality"))
        listOne.add(HomeCategoriesModel("education_learning", "Education"))
        initCategoriesRecyclerView(listOne)

        binding.backArrow.setOnClickListener {
            finish()
        }
    }

    private fun initCategoriesRecyclerView(list: List<HomeCategoriesModel>){
        val mLayoutManager = GridLayoutManager(this, 3)
        binding.categoriesRecycler.apply {
            layoutManager = mLayoutManager
            adapter = HomeCategoriesAdapter(list,this@AdPostActivity, this@AdPostActivity)
        }
    }

    override fun onClick(view: View, data: String?) {
        if(data == "Properties"){
            val intent = Intent(this, PropertiesFormActivity::class.java)
            startActivity(intent)
        }else if(data == "Vehicle"){
            val intent = Intent(this, VehicleFormActivity::class.java)
            startActivity(intent)
        }else if(data == "Health"){
            val intent = Intent(this, HealthFormActivity::class.java)
            startActivity(intent)
        }else if(data == "Hospitality"){
            val intent = Intent(this, HospitalityFormActivity::class.java)
            startActivity(intent)
        }else if(data == "Education"){
            val intent = Intent(this, EducationFormActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show()
        }
    }
}