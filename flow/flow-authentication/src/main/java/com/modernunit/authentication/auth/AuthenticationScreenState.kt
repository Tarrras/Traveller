package com.modernunit.authentication.auth

import androidx.compose.runtime.Immutable
import com.modernunit.authentication.auth.validator.EmailValidationResult
import com.modernunit.authentication.auth.validator.PasswordRequirement
import com.modernunit.authentication.auth.validator.isValid
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class AuthenticationScreenState(
    val mode: AuthenticationMode,
    val emailField: String?,
    val emailValidationResult: EmailValidationResult?,
    val passwordField: String?,
    val passwordValidationResult: ImmutableList<PasswordRequirement>,
    val isFeatureIsNotAvailableMessageShow: Boolean,
    val isLoading: Boolean,
    val isInternetConnectionAvailable: Boolean,
    val errorMessage: String?,
    val isAuthSuccess: Boolean,
) {
    val isLogInButtonEnabled
        get() = (
            emailValidationResult?.isValid == true &&
                passwordValidationResult.isNotEmpty() &&
                !isLoading &&
                isInternetConnectionAvailable
            )
}

val EmptyAuthenticationScreenState = AuthenticationScreenState(
    mode = AuthenticationMode.SIGN_IN,
    emailField = null,
    emailValidationResult = null,
    passwordField = null,
    passwordValidationResult = persistentListOf(),
    isFeatureIsNotAvailableMessageShow = false,
    isLoading = false,
    isInternetConnectionAvailable = true,
    errorMessage = null,
    isAuthSuccess = false
)

enum class AuthenticationMode {
    SIGN_IN, SIGN_UP
}
