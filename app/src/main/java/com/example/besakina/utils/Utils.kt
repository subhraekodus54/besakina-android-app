package com.example.besakina.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

fun ViewGroup.inflate(layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(this.context).inflate(layoutRes, this, attachToRoot)
}

fun Context.isConnectedToInternet(): Boolean {
    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    return activeNetwork?.isConnected ?: false
}

fun String.toMultipartFormString(): RequestBody {
    return this.toRequestBody(MultipartBody.FORM)
}

fun Context.createMultiPart(keyName: String, photoPath: File): MultipartBody.Part {

    val requestFile = photoPath.asRequestBody("image/*".toMediaTypeOrNull())
    Log.i("xxx ",requestFile.toString())
    return MultipartBody.Part.createFormData(keyName, photoPath.name, requestFile)

}