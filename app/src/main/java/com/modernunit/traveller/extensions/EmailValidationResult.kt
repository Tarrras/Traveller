package com.modernunit.traveller.extensions

import android.util.Patterns
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.modernunit.traveller.R

sealed class EmailValidationResult {
    object Valid : EmailValidationResult()
    object MustBeNotEmpty : EmailValidationResult()
    data class ValidationFailed(@StringRes val cause: Int) : EmailValidationResult()
}

fun String.validateEmail() = when {
    isEmpty() -> EmailValidationResult.MustBeNotEmpty
    matches(Patterns.EMAIL_ADDRESS.toRegex()).not() -> EmailValidationResult.ValidationFailed(R.string.invalid_email_error)
    else -> EmailValidationResult.Valid
}


@Composable
fun EmailValidationResult.toValidationTextResult() = when (this) {
    is EmailValidationResult.ValidationFailed -> stringResource(id = cause)
    is EmailValidationResult.MustBeNotEmpty -> stringResource(id = R.string.empty_field_error)
    else -> null
}

val EmailValidationResult.isValid
    get() = this is EmailValidationResult.Valid