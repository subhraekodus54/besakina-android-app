package com.example.besakina.retrofit

import com.example.besakina.model.pojo.login_mobile.LoginNumberReponse
import com.example.besakina.model.pojo.login_mobile.LoginNumberRequest
import com.example.besakina.model.pojo.login_otp.LoginOtpRequest
import com.example.besakina.model.pojo.login_otp.LoginOtpResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface ApiInterface {

    @POST("api/users/sendotp")
    suspend fun loginNumber(@Body body: LoginNumberRequest?): LoginNumberReponse?

    @POST("api/users/login")
    suspend fun loginOtp(@Body body: LoginOtpRequest?): LoginOtpResponse?


    /*@GET("notification/unread-notification")
    suspend fun getNotifications(
        @Header("Authorization") token: String,
    ): GetNotificationsResponse?

    @POST("notification/mark-as-read")
    suspend fun markReadNotification(
        @Body body: MarkReadNotificationRequest?,
        @Header("Authorization") token: String
    ): MarkReadNotificationResponse?*/
}