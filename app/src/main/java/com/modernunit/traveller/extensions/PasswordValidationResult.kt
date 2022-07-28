package com.modernunit.traveller.extensions

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.modernunit.traveller.R

sealed class PasswordValidationResult {
    object Valid : PasswordValidationResult()
    object MustBeNotEmpty : PasswordValidationResult()
    data class ValidationFailed(@StringRes val cause: Int) : PasswordValidationResult()
}

fun String.validatePassword() = when {
    isEmpty() -> PasswordValidationResult.MustBeNotEmpty
    matches(PASSWORD_PATTERN.toRegex()).not() -> PasswordValidationResult.ValidationFailed(R.string.invalid_password_error)
    else -> PasswordValidationResult.Valid
}

@Composable
fun PasswordValidationResult.toValidationTextResult() = when (this) {
    is PasswordValidationResult.ValidationFailed -> stringResource(id = cause)
    is PasswordValidationResult.MustBeNotEmpty -> stringResource(id = R.string.empty_field_error)
    else -> null
}

val PasswordValidationResult.isValid
    get() = this is PasswordValidationResult.Valid

private const val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$"
