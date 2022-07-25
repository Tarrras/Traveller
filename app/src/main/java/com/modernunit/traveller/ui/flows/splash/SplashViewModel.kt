package com.modernunit.traveller.ui.flows.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    private val auth = Firebase.auth

    private val mutableIsLogged = MutableStateFlow<SplashUiState>(SplashUiState.NoData)
    val isLogged = mutableIsLogged.asStateFlow()

    fun checkLoggedStatus() {
        viewModelScope.launch {
            delay(2000)
            mutableIsLogged.value = SplashUiState.DataLoaded(auth.currentUser != null)
        }
    }
}

sealed class SplashUiState {
    object NoData : SplashUiState()
    data class DataLoaded(val isLogged: Boolean) : SplashUiState()
}