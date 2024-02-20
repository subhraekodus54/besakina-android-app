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

class EducationFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEducationFormBinding
    val courseTypeList: Array<String> =  arrayOf("Select Course Type","Graduation","Diploma","Certification")
    val domainList: Array<String> =  arrayOf("Select Domain","Science","Arts","Commerce","Computer Science","Cooking","Electronics")

    var courseType: String = ""
    var domain: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEducationFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backArrow.setOnClickListener {
            finish()
        }

        binding.postBtn.setOnClickListener {
            showAcceptDialog()
        }

        //spinner
        setTypeSpinner()
        setDomainSpinner()
    }
    private fun setTypeSpinner(){
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,courseTypeList)
        binding.typeSpinner.adapter = arrayAdapter
        binding.typeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 0){
                    courseType = ""
                }else{
                    courseType = courseTypeList[p2]
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }
        }
    }
    private fun setDomainSpinner(){
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,domainList)
        binding.domainSpinner.adapter = arrayAdapter
        binding.domainSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 0){
                    domain = ""
                }else{
                    domain = domainList[p2]
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