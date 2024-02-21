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
import com.example.besakina.databinding.ActivityDoctorsFormBinding
import com.example.besakina.databinding.ActivityHospitalTypeBinding

class DoctorsFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDoctorsFormBinding
    val expertiseList: Array<String> =  arrayOf("Select expertise", "Child", "Gastro intestine", "Cardiology", "Ophthalmology", "Orthopaedic","Gynecology","Emergency medicine","Physician","Others")

    var expertise: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDoctorsFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backArrow.setOnClickListener {
            finish()
        }
        binding.postBtn.setOnClickListener {
            showAcceptDialog()
        }
        //spinner
        setExpertiseSpinner()
    }

    private fun setExpertiseSpinner(){
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,expertiseList)
        binding.expertiesSpinner.adapter = arrayAdapter
        binding.expertiesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 0){
                    expertise = ""
                }else{
                    expertise = expertiseList[p2]
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