package com.example.besakina.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog
import com.airbnb.lottie.LottieAnimationView
import com.example.besakina.R
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
fun Activity.hideSoftKeyboard() {
    val inputMethodManager = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    if (inputMethodManager.isActive) {
        if (this.currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(this.currentFocus!!.windowToken, 0)
        }
    }
}

fun View.showKeyboard() {
    this.requestFocus()
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}
fun AlertDialog.invisibleBg() {
    this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
}

fun Activity.loadingDialog(cancelable: Boolean = false, lottieFile: Int? = null): AlertDialog {
    val nullParent: ViewGroup? = null
    val inflater = this.layoutInflater
    val alertLayout = inflater.inflate(R.layout.loadingdialog, nullParent)
    val loadingAnimation: LottieAnimationView = alertLayout.findViewById<LottieAnimationView>(R.id.loadingAnimation)

    val loading = AlertDialog.Builder(this)
        .setView(alertLayout)
        .setCancelable(cancelable)
        .create()
    loading.invisibleBg()
    if (lottieFile != null) {
        loadingAnimation.setAnimation(lottieFile)
    }
    return loading
}


fun String.toMultipartFormString(): RequestBody {
    return this.toRequestBody(MultipartBody.FORM)
}

fun Context.createMultiPart(keyName: String, photoPath: File): MultipartBody.Part {

    val requestFile = photoPath.asRequestBody("image/*".toMediaTypeOrNull())
    Log.i("xxx ",requestFile.toString())
    return MultipartBody.Part.createFormData(keyName, photoPath.name, requestFile)
}