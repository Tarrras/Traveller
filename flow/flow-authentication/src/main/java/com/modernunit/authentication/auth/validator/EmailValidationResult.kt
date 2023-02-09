package com.modernunit.authentication.auth.validator

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.modernunit.authentication.R

sealed class EmailValidationResult {
    object Valid : EmailValidationResult()
    object EmptyValue : EmailValidationResult()
    object PatternValidationFailed : EmailValidationResult()
}

fun String.validateEmail() = when {
    isEmpty() -> EmailValidationResult.EmptyValue
    matches(EMAIL_PATTERN.toRegex()).not() -> EmailValidationResult.PatternValidationFailed
    else -> EmailValidationResult.Valid
}

@Composable
fun EmailValidationResult.toValidationTextResult() = when (this) {
    is EmailValidationResult.PatternValidationFailed -> stringResource(id = R.string.invalid_email_error)
    is EmailValidationResult.EmptyValue -> stringResource(id = R.string.empty_field_error)
    else -> null
}

val EmailValidationResult.isValid
    get() = this is EmailValidationResult.Valid

private const val EMAIL_PATTERN = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
        "\\@" +
        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
        "(" +
        "\\." +
        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
        ")+"
