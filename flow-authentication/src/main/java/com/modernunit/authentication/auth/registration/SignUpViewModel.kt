package com.modernunit.authentication.auth.registration

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.modernunit.background.connection.TravellerConnectivityManager
import com.modernunit.data.auth.IAuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val authenticationRepository: IAuthenticationRepository,
    travellerConnectivityManager: TravellerConnectivityManager
) : ViewModel() {
    /*val connectionState = travellerConnectivityManager.networkEvents

    private val isInternetConnectionAvailable = connectionState.map {
        it == NetworkState.AVAILABLE
    }

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

    private val mutableSignUpState =
        MutableStateFlow<AuthenticationScreenState>(AuthenticationScreenState.None)
    val signUpState = mutableSignUpState.asStateFlow()

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

    fun onSignUp() = flow {
        authenticationRepository.signUp(
            email = requireNotNull(userEmail.value) {
                "Email is null!"
            },
            password = requireNotNull(userPassword.value) {
                "Password is null!"
            }
        ).let { emit(it) }
    }.onStart {
        mutableIsInProgress.value = true
        mutableSignUpState.value = AuthenticationScreenState.None
    }.catch { cause ->
        mutableSignUpState.value =
            AuthenticationScreenState.AuthenticationError(cause.localizedMessage ?: "")
    }.onCompletion {
        mutableIsInProgress.value = false
    }.onEach { isSignUpSuccessfully ->
        mutableSignUpState.value = if (isSignUpSuccessfully) {
            AuthenticationScreenState.AuthenticationSuccessfully
        } else AuthenticationScreenState.AuthenticationError("Ooops")
    }.launchIn(viewModelScope)

    val isSignUpButtonEnabled = combine(
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

    private fun clearAuthError() {
        if (mutableSignUpState.value is AuthenticationScreenState.AuthenticationError) {
            mutableSignUpState.value = AuthenticationScreenState.None
        }
    }*/
}
