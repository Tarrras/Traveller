package com.modernunit.traveller.ui.flows.login.userLogIn

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.modernunit.traveller.extensions.isValid
import com.modernunit.traveller.extensions.validateEmail
import com.modernunit.traveller.extensions.validatePassword
import com.modernunit.traveller.service.NetworkState
import com.modernunit.traveller.service.TravellerConnectivityManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class LogInViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    travellerConnectivityManager: TravellerConnectivityManager
) : ViewModel() {
    val connectionState = travellerConnectivityManager.networkEvents

    private val isInternetConnectionAvailable = connectionState.map {
        it == NetworkState.AVAILABLE
    }

    private val mutableIsInProgress = MutableStateFlow(false)
    val isInProgress = mutableIsInProgress.asStateFlow()

    val userEmail = savedStateHandle.getStateFlow<String?>("email", null)
    val userEmailValidation = userEmail
        .map { email -> email?.validateEmail() }
        .debounce(500)
        .stateIn(
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null,
            scope = viewModelScope
        )

    val userPassword = savedStateHandle.getStateFlow<String?>("password", null)
    val userPasswordValidation = userPassword
        .map { password -> password?.validatePassword() }
        .debounce(500)
        .stateIn(
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null,
            scope = viewModelScope
        )


    fun onEmailChanged(email: String) {
        savedStateHandle["email"] = email
    }

    fun onPasswordChanged(password: String) {
        savedStateHandle["password"] = password
    }

    fun onLogIn() {

    }

    fun onForgotPassword() {

    }

    val isLogInButtonEnabled = combine(
        userEmailValidation,
        userPasswordValidation,
        isInProgress,
        isInternetConnectionAvailable
    ) { userEmailValidation, userPasswordValidation, isInProgress, isInternetConnectionAvailable ->
        userEmailValidation?.isValid == true
                && userPasswordValidation?.isValid == true
                && !isInProgress
                && isInternetConnectionAvailable
    }
}