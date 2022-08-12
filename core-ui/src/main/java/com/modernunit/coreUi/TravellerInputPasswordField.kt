package com.modernunit.coreUi

import androidx.compose.animation.animateColorAsState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
    enabled: Boolean = true,
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
    TravellerInputTextField(
        modifier = modifier,
        text = password,
        onValueChanged = onPasswordChanged,
        error = error,
        enabled = enabled,
        trailingIcon = {
            IconButton(onClick = {
                isTextVisible = !isTextVisible
            }, enabled = password.isNotEmpty()) {
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
}