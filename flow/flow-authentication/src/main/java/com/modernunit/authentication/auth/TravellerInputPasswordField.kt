package com.modernunit.authentication.auth

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.modernunit.authentication.R
import com.modernunit.authentication.auth.passwordStrengthMeter.PasswordStrengthMeter
import com.modernunit.authentication.auth.validator.PasswordRequirement
import com.modernunit.designsystem.base.TravellerInputTextField
import com.modernunit.designsystem.theme.TravellerTheme

/**
 * Input field used on the following screens: Sign In, Sign Up
 */
@Composable
fun TravellerInputPasswordField(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChanged: (String) -> Unit,
    error: String? = null,
    passwordSatisfiedRequirements: List<PasswordRequirement>,
    enabled: Boolean = true,
    needToShowStrengthMeter: Boolean = false
) {
    var isTextVisible by remember { mutableStateOf(false) }
    val passwordIconTint by animateColorAsState(
        targetValue = if (isTextVisible) {
            MaterialTheme.colors.primary
        } else TravellerTheme.colors.extendedGrey.copy(alpha = 1f)
    )
    val visualTransformation = remember(isTextVisible) {
        if (isTextVisible) VisualTransformation.None
        else PasswordVisualTransformation()
    }
    Column(modifier = modifier) {
        TravellerInputTextField(
            modifier = Modifier.testTag(InputPasswordFieldTestTag),
            text = password,
            onValueChanged = onPasswordChanged,
            error = error,
            enabled = enabled,
            trailingIcon = {
                IconButton(
                    modifier = Modifier.testTag(PasswordEyeTestTag),
                    onClick = {
                        isTextVisible = !isTextVisible
                    }, enabled = password.isNotEmpty()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_password_eye),
                        contentDescription = stringResource(R.string.password_field),
                        tint = passwordIconTint
                    )
                }
            },
            visualTransformation = visualTransformation,
            keyboardType = KeyboardType.Password,
            placeholderText = stringResource(id = R.string.password_field)
        )
        if (needToShowStrengthMeter) {
            Spacer(modifier = Modifier.height(16.dp))
            PasswordStrengthMeter(
                modifier = Modifier.padding(horizontal = 12.dp),
                passwordSatisfiedRequirements = passwordSatisfiedRequirements
            )
        }
    }
}

const val InputPasswordFieldTestTag = "TravellerInputPasswordFieldTestTag"
const val PasswordEyeTestTag = "PasswordEyeTestTag"