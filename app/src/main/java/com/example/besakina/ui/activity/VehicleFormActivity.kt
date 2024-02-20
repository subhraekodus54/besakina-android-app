package com.example.besakina.ui.activity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.besakina.R
import com.example.besakina.databinding.ActivityAdPostBinding
import com.example.besakina.databinding.ActivityEducationFormBinding
import com.example.besakina.databinding.ActivityVehicleFormBinding

class VehicleFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVehicleFormBinding
    val typeList: Array<String> =  arrayOf("Select Vehicle Type","Car","Motorcycle","Scooter","Bicycle")
    val brandList: Array<String> =  arrayOf("Select Brand","BMW","Ford","Fiat","Honda", "Hyundai","Jeep", "Mercedes","Toyota")

    var type: String = ""
    var brand: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityVehicleFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backArrow.setOnClickListener {
            finish()
        }

        binding.postBtn.setOnClickListener {
            showAcceptDialog()
        }

        //spinner
        setUpBrandSpinner()
        setUpTypeSpinner()
    }
    private fun setUpBrandSpinner(){
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,brandList)
        binding.brandSpinner.adapter = arrayAdapter
        binding.brandSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 0){
                    brand = ""
                }else{
                    brand = brandList[p2]
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }
        }
    }

    private fun setUpTypeSpinner(){
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,typeList)
        binding.typeSpinner.adapter = arrayAdapter
        binding.typeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 0){
                    type = ""
                }else{
                    type = typeList[p2]
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }
        }
    }
    private fun showAcceptDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.ad_post_success_dialog_layout)

        val okay = dialog.findViewById<TextView>(R.id.ok_btn)

        okay.setOnClickListener {
            dialog.dismiss()
            finish()
        }
        dialog.show()
    }
}