package com.modernunit.authentication.auth.passwordStrengthMeter

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.modernunit.authentication.R

sealed class PasswordStrengthMeterState(val absoluteProgress: Float) {
    object Empty : PasswordStrengthMeterState(0f)
    object Weak : PasswordStrengthMeterState(0.25f)
    object Medium : PasswordStrengthMeterState(0.5f)
    object Almost : PasswordStrengthMeterState(0.75f)
    object Awesome : PasswordStrengthMeterState(1f)
}

fun PasswordStrengthMeterState.getStateColor(
    colors: PasswordStrengthMeterColors
): Color {
    return when (this) {
        PasswordStrengthMeterState.Empty -> Color.Transparent
        PasswordStrengthMeterState.Weak -> colors.weakStrengthBackgroundColor
        PasswordStrengthMeterState.Medium -> colors.mediumStrengthBackgroundColor
        PasswordStrengthMeterState.Almost -> colors.almostStrengthBackgroundColor
        PasswordStrengthMeterState.Awesome -> colors.awesomeStrengthBackgroundColor
    }
}

@Composable
fun PasswordStrengthMeterState.getEmojiStatus(): String {
    return when (this) {
        PasswordStrengthMeterState.Empty -> stringResource(id = R.string.empty_password_start)
        PasswordStrengthMeterState.Weak -> stringResource(id = R.string.weak_password_start)
        PasswordStrengthMeterState.Medium -> stringResource(id = R.string.medium_password_start)
        PasswordStrengthMeterState.Almost -> stringResource(id = R.string.almost_password_start)
        PasswordStrengthMeterState.Awesome -> stringResource(id = R.string.awesome_password_start)
    }
}
