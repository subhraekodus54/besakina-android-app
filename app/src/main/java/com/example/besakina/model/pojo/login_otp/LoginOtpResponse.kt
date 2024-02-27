package com.example.besakina.model.pojo.login_otp

data class LoginOtpResponse(
    val message: String,
    val success: Boolean,
    val token: String
)