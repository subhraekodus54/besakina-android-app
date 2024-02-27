package com.example.besakina.model.repository

import com.example.besakina.model.pojo.login_mobile.LoginNumberReponse
import com.example.besakina.model.pojo.login_mobile.LoginNumberRequest
import com.example.besakina.retrofit.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoginNumberRepository @Inject constructor(private val apiInterface: ApiInterface)  {
    fun loginNumber(
        mobile: Long
    ): Flow<LoginNumberReponse?> = flow{
        emit(apiInterface.loginNumber(LoginNumberRequest(mobile)))
    }.flowOn(Dispatchers.IO)
}