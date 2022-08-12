package com.modernunit.traveller.ui.flows.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun TravellerInputPasswordField(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChanged: (String) -> Unit,
    error: String? = null,
    enabled: Boolean = true,
) {
/*    var isTextVisible by remember { mutableStateOf(false) }
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
    )*/
}