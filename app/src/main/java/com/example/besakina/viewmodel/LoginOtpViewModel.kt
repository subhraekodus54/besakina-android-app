package com.example.besakina.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besakina.model.pojo.login_otp.LoginOtpResponse
import com.example.besakina.model.repository.LoginOtpRepository
import com.example.besakina.model.repository.Outcome
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginOtpViewModel @Inject constructor(private val repository: LoginOtpRepository) : ViewModel() {
    private var _response = MutableLiveData<Outcome<LoginOtpResponse?>?>()
    val response: LiveData<Outcome<LoginOtpResponse?>?> = _response

    fun loginOtp(
        mobile: Long,
        otp: Long
    ) = viewModelScope.launch {
        repository.loginOtp(mobile, otp).onStart {
            _response.value = Outcome.loading(true)
        }.catch {
            _response.value = Outcome.Failure(it)
        }.collect {
            _response.value = Outcome.success(it)
        }
    }

    fun navigationComplete(){
        _response.value = null
    }
}