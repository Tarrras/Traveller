package com.modernunit.authentication.auth.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.modernunit.authentication.auth.AuthenticationScreenEvent
import com.modernunit.authentication.auth.EmptyAuthenticationScreenState
import com.modernunit.authentication.auth.validator.validateEmail
import com.modernunit.authentication.auth.validator.validatePassword
import com.modernunit.background.connection.NetworkState
import com.modernunit.background.connection.TravellerConnectivityManager
import com.modernunit.data.auth.IAuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val authenticationRepository: IAuthenticationRepository,
    travellerConnectivityManager: TravellerConnectivityManager
) : ViewModel() {
    private val mutableUiState =
        MutableStateFlow(EmptyAuthenticationScreenState)
    val uiState = mutableUiState.asStateFlow()

    fun handleEvent(event: AuthenticationScreenEvent) {
        when (event) {
            AuthenticationScreenEvent.Authenticate -> onLogIn()
            is AuthenticationScreenEvent.EmailChangedEvent -> onEmailChanged(event.email)
            is AuthenticationScreenEvent.PasswordChangedEvent -> onPasswordChanged(event.password)
            AuthenticationScreenEvent.ForgotPasswordEvent,
            AuthenticationScreenEvent.AuthenticateWithFacebook,
            AuthenticationScreenEvent.AuthenticateWithGoogle -> showFeatureIsNotAvailableMessage()
        }
    }

    val connectionState = flow<Unit> {
        travellerConnectivityManager.networkEvents.collect { event ->
            mutableUiState.getAndUpdate { it.copy(isInternetConnectionAvailable = event == NetworkState.AVAILABLE) }
        }
    }.launchIn(viewModelScope)

    private fun showFeatureIsNotAvailableMessage() = viewModelScope.launch {
        if (!mutableUiState.value.isFeatureIsNotAvailableMessageShow) {
            mutableUiState.getAndUpdate { it.copy(isFeatureIsNotAvailableMessageShow = true) }
            delay(3000L)
            mutableUiState.getAndUpdate { it.copy(isFeatureIsNotAvailableMessageShow = false) }
        }
    }

    private val userEmailValidation = mutableUiState
        .map { state -> state.emailField?.validateEmail() }
        .onEach {
            mutableUiState.value = mutableUiState.value.copy(emailValidationResult = it)
        }.launchIn(viewModelScope)

    private val userPasswordValidation = mutableUiState
        .map { state -> state.passwordField?.validatePassword() }
        .onEach {
            mutableUiState.value = mutableUiState.value.copy(passwordValidationResult = it)
        }.launchIn(viewModelScope)


    private fun onEmailChanged(email: String) {
        mutableUiState.value = mutableUiState.value.copy(emailField = email)
        clearAuthError()
    }

    private fun onPasswordChanged(password: String) {
        mutableUiState.value = mutableUiState.value.copy(passwordField = password)
        clearAuthError()
    }

    private fun onLogIn() = flow {
        authenticationRepository.logIn(
            email = requireNotNull(mutableUiState.value.emailField) {
                "Email is null!"
            },
            password = requireNotNull(mutableUiState.value.passwordField) {
                "Password is null!"
            }
        ).let { emit(it) }
    }.onStart {
        mutableUiState.update { it.copy(isLoading = true) }
    }.catch { cause ->
        mutableUiState.update { it.copy(errorMessage = cause.localizedMessage ?: "") }
    }.onCompletion {
        mutableUiState.update { it.copy(isLoading = false) }
    }.onEach { isSignUpSuccessfully ->
        when (isSignUpSuccessfully) {
            true -> {}
            else -> mutableUiState.update { it.copy(errorMessage = "Ooops") }
        }
    }.launchIn(viewModelScope)

    private fun clearAuthError() {
        mutableUiState.getAndUpdate { state ->
            state.copy(errorMessage = null)
        }
    }
}