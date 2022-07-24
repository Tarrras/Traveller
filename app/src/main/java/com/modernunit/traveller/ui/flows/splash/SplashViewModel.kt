package com.modernunit.traveller.ui.flows.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    private val auth = Firebase.auth

    var isUserLogged by mutableStateOf<Boolean?>(null)
        private set

    fun checkLoggedStatus() {
        viewModelScope.launch {
            delay(2000)
            isUserLogged = auth.currentUser != null
        }
    }
}