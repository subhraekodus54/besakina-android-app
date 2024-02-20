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
import com.example.besakina.databinding.ActivityPropertiesFormBinding

class PropertiesFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPropertiesFormBinding

    val bedRoomList: Array<String> =  arrayOf("Select Bedrooms", "1", "2", "3", "4", "4+")
    val bathRoomsList: Array<String> =  arrayOf("Select Bathrooms", "1", "2", "3", "4", "4+")
    val listedByList: Array<String> =  arrayOf("Listed by", "Builder", "Dealer", "Owner")
    val parkingByList: Array<String> =  arrayOf("Car parking", "0", "1", "2", "3", "3+")

    var bedRoom: String = ""
    var bathRoom: String = ""
    var listedBy: String = ""
    var parking: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPropertiesFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //spinner
        setUpBedroomSpinner()
        setUpBathroomSpinner()
        setUpListedBySpinner()
        setUpParkingSpinner()

        binding.backArrow.setOnClickListener {
            finish()
        }

        binding.postBtn.setOnClickListener {
            showAcceptDialog()
        }
    }
    private fun setUpBedroomSpinner(){
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,bedRoomList)
        binding.bedroomsSpinner.adapter = arrayAdapter
        binding.bedroomsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 0){
                    bedRoom = ""
                }else{
                    bedRoom = bedRoomList[p2]
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }
        }
    }

    private fun setUpBathroomSpinner(){
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,bathRoomsList)
        binding.bathroomsSpinner.adapter = arrayAdapter
        binding.bathroomsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 0){
                    bathRoom = ""
                }else{
                    bathRoom = bathRoomsList[p2]
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }
        }
    }

    private fun setUpListedBySpinner(){
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,listedByList)
        binding.listedBySpinner.adapter = arrayAdapter
        binding.listedBySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 0){
                    listedBy = ""
                }else{
                    listedBy = listedByList[p2]
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }
        }
    }

    private fun setUpParkingSpinner(){
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,parkingByList)
        binding.parkingSpinner.adapter = arrayAdapter
        binding.parkingSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 0){
                    parking = ""
                }else{
                    parking = parkingByList[p2]
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