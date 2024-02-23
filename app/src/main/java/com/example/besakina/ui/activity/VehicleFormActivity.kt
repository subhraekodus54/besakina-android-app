package com.example.besakina.ui.activity

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import com.example.besakina.R
import com.example.besakina.databinding.ActivityAdPostBinding
import com.example.besakina.databinding.ActivityEducationFormBinding
import com.example.besakina.databinding.ActivityVehicleFormBinding
import com.example.besakina.model.ImageListModel
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import java.io.File
import java.io.InputStream

class VehicleFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVehicleFormBinding
    val typeList: Array<String> =  arrayOf("Select Vehicle Type","Car","Motorcycle","Scooter","Bicycle")
    val brandList: Array<String> =  arrayOf("Select Brand","BMW","Ford","Fiat","Honda", "Hyundai","Jeep", "Mercedes","Toyota")

    var type: String = ""
    var brand: String = ""

    private val PICK_IMAGE_DOC = 101
    private var imageUri: Uri? = null
    private var absolutePath: String? = null
    private val imageList:MutableList<ImageListModel> = mutableListOf()

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

        binding.uploadPhotoBtn.setOnClickListener {
            if(checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                dispatchDocGalleryIntent()
            }else{
                requestStoragePermission()
            }
        }
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

    private fun requestStoragePermission() {
        Dexter.withContext(this)
            .withPermission(
                Manifest.permission.READ_EXTERNAL_STORAGE,
            )
            .withListener(object : PermissionListener {

                override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                    dispatchDocGalleryIntent()
                }

                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                    requestStoragePermission()
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: PermissionRequest?,
                    token: PermissionToken?
                ) {
                    token?.continuePermissionRequest()
                }
            })
            .onSameThread()
            .check()
    }

    private fun dispatchDocGalleryIntent() {
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        gallery.setType("image/*")
        startActivityForResult(gallery, PICK_IMAGE_DOC)
    }

    fun getRealPathFromUri(contentUri: Uri?): String? {
        var cursor: Cursor? = null
        return try {
            val proj = arrayOf(MediaStore.Images.Media.DATA)
            cursor = this.contentResolver.query(contentUri!!, proj, null, null, null)
            assert(cursor != null)
            val columnIndex: Int = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            cursor.moveToFirst()
            cursor.getString(columnIndex)
        } finally {
            if (cursor != null) {
                cursor.close()
            }
        }
    }

    private fun setImage(uri: Uri, path: String){
        imageList.add(ImageListModel(uri, path))

        val imageStream: InputStream = uri?.let {
            this.getContentResolver().openInputStream(
                it
            )
        }!!
        val selectedImage: Bitmap = BitmapFactory.decodeStream(imageStream)
        binding.uploadPhotoBtn.setImageBitmap(selectedImage)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == PICK_IMAGE_DOC) {
            try {
                imageUri = data?.data
                val path = getRealPathFromUri(imageUri)
                val imageFile = File(path!!)
                absolutePath = imageFile.absolutePath
                setImage(imageUri!!, absolutePath!!)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}