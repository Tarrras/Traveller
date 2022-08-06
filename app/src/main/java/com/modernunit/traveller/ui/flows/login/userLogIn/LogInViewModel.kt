package com.modernunit.traveller.ui.flows.login.userLogIn

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.modernunit.traveller.coreData.repository.auth.IAuthenticationRepository
import com.modernunit.traveller.extensions.isValid
import com.modernunit.traveller.extensions.validateEmail
import com.modernunit.traveller.extensions.validatePassword
import com.modernunit.traveller.service.NetworkState
import com.modernunit.traveller.service.TravellerConnectivityManager
import com.modernunit.traveller.ui.flows.login.userSignUp.AuthenticationUserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val authenticationRepository: IAuthenticationRepository,
    travellerConnectivityManager: TravellerConnectivityManager
) : ViewModel() {
    val connectionState = travellerConnectivityManager.networkEvents

    private val isInternetConnectionAvailable = connectionState.map {
        it == NetworkState.AVAILABLE
    }

    private val mutableLogInState =
        MutableStateFlow<AuthenticationUserState>(AuthenticationUserState.None)
    val logInState = mutableLogInState.asStateFlow()

    private val mutableIsInProgress = MutableStateFlow(false)
    val isInProgress = mutableIsInProgress.asStateFlow()

    private val mutableFeatureIsNotAvailableShown = MutableStateFlow(false)
    val featureIsNotAvailableShown = mutableFeatureIsNotAvailableShown.asStateFlow()

    fun showFeatureIsNotAvailableMessage() = viewModelScope.launch {
        if (!mutableFeatureIsNotAvailableShown.value) {
            mutableFeatureIsNotAvailableShown.value = true
            delay(3000L)
            mutableFeatureIsNotAvailableShown.value = false
        }
    }

    val userEmail = savedStateHandle.getStateFlow<String?>("email", null)
    val userEmailValidation = userEmail
        .map { email -> email?.validateEmail() }
        .stateIn(
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null,
            scope = viewModelScope
        )

    val userPassword = savedStateHandle.getStateFlow<String?>("password", null)
    val userPasswordValidation = userPassword
        .map { password -> password?.validatePassword() }
        .stateIn(
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null,
            scope = viewModelScope
        )


    fun onEmailChanged(email: String) {
        savedStateHandle["email"] = email
        clearAuthError()
    }

    fun onPasswordChanged(password: String) {
        savedStateHandle["password"] = password
        clearAuthError()
    }

    fun onLogIn() = flow {
        authenticationRepository.logIn(
            email = requireNotNull(userEmail.value) {
                "Email is null!"
            },
            password = requireNotNull(userPassword.value) {
                "Password is null!"
            }
        ).let { emit(it) }
    }.onStart {
        mutableIsInProgress.value = true
        mutableLogInState.value = AuthenticationUserState.None
    }.catch { cause ->
        mutableLogInState.value =
            AuthenticationUserState.AuthenticationError(cause.localizedMessage ?: "")
    }.onCompletion {
        mutableIsInProgress.value = false
    }.onEach { isSignUpSuccessfully ->
        mutableLogInState.value = if (isSignUpSuccessfully) {
            AuthenticationUserState.AuthenticationSuccessfully
        } else AuthenticationUserState.AuthenticationError("Ooops")
    }.launchIn(viewModelScope)

    fun onForgotPassword() {
        showFeatureIsNotAvailableMessage()
    }

    private fun clearAuthError() {
        if (mutableLogInState.value is AuthenticationUserState.AuthenticationError) {
            mutableLogInState.value = AuthenticationUserState.None
        }
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