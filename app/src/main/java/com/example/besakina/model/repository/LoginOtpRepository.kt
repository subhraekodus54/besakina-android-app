package com.example.besakina.model.repository

import com.example.besakina.model.pojo.login_otp.LoginOtpRequest
import com.example.besakina.model.pojo.login_otp.LoginOtpResponse
import com.example.besakina.retrofit.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoginOtpRepository @Inject constructor(private val apiInterface: ApiInterface)  {
    fun loginOtp(
        mobile: Long,
        otp: Long
    ): Flow<LoginOtpResponse?> = flow{
        emit(apiInterface.loginOtp(LoginOtpRequest(mobile, otp)))
    }.flowOn(Dispatchers.IO)
}