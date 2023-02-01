package com.modernunit.common.validator

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.modernunit.common.R

sealed class PasswordValidationResult {
    object Valid : PasswordValidationResult()
    object EmptyValue : PasswordValidationResult()
    object PatternValidationFailed : PasswordValidationResult()
}

fun String.validatePassword() = when {
    isEmpty() -> PasswordValidationResult.EmptyValue
    matches(PASSWORD_PATTERN.toRegex()).not() -> PasswordValidationResult.PatternValidationFailed
    else -> PasswordValidationResult.Valid
}

@Composable
fun PasswordValidationResult.toValidationTextResult() = when (this) {
    is PasswordValidationResult.PatternValidationFailed -> stringResource(R.string.invalid_password_error)
    is PasswordValidationResult.EmptyValue -> stringResource(id = R.string.empty_field_error)
    else -> null
}

val PasswordValidationResult.isValid
    get() = this is PasswordValidationResult.Valid

private const val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$"
