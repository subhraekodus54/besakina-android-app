package com.example.besakina.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besakina.model.pojo.login_mobile.LoginNumberReponse
import com.example.besakina.model.repository.LoginNumberRepository
import com.example.besakina.model.repository.Outcome
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginNumberViewModel @Inject constructor(private val repository: LoginNumberRepository) : ViewModel() {
    private var _response = MutableLiveData<Outcome<LoginNumberReponse?>?>()
    val response: LiveData<Outcome<LoginNumberReponse?>?> = _response

    fun loginNumber(
        mobile: Long,
    ) = viewModelScope.launch {
        repository.loginNumber(mobile).onStart {
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