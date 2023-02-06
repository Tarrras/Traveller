package com.modernunit.authentication.auth

import com.modernunit.authentication.auth.validator.EmailValidationResult
import com.modernunit.authentication.auth.validator.PasswordValidationResult
import com.modernunit.authentication.auth.validator.isValid

data class AuthenticationScreenState(
    val mode: AuthenticationMode,
    val emailField: String?,
    val emailValidationResult: EmailValidationResult?,
    val passwordField: String?,
    val passwordValidationResult: PasswordValidationResult?,
    val isFeatureIsNotAvailableMessageShow: Boolean,
    val isLoading: Boolean,
    val isInternetConnectionAvailable: Boolean,
    val errorMessage: String?,
    val isAuthSuccess: Boolean,
) {
    val isLogInButtonEnabled
        get() = (emailValidationResult?.isValid == true
                && passwordValidationResult?.isValid == true
                && !isLoading
                && isInternetConnectionAvailable)
}

val EmptyAuthenticationScreenState = AuthenticationScreenState(
    mode = AuthenticationMode.SIGN_IN,
    emailField = null,
    emailValidationResult = null,
    passwordField = null,
    passwordValidationResult = null,
    isFeatureIsNotAvailableMessageShow = false,
    isLoading = false,
    isInternetConnectionAvailable = true,
    errorMessage = null,
    isAuthSuccess = false
)

enum class AuthenticationMode {
    SIGN_IN, SIGN_UP
}
