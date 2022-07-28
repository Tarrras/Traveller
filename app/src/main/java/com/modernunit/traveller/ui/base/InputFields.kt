package com.modernunit.traveller.ui.base

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.modernunit.traveller.R
import com.modernunit.traveller.extensions.bringIntoViewAfterImeAnimation
import com.modernunit.traveller.ui.theme.TravellerTheme

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

@Composable
fun TravellerInputTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChanged: (String) -> Unit,
    error: String? = null,
    enabled: Boolean = true,
    placeholderText: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val shape = remember { RoundedCornerShape(30.dp) }
    val focusManager = LocalFocusManager.current
    Column(modifier = modifier.animateContentSize()) {
        TravellerTextField(
            modifier = Modifier
                .bringIntoViewAfterImeAnimation()
                .fillMaxWidth(),
            value = text,
            onValueChange = onValueChanged,
            isError = error != null,
            enabled = enabled,
            placeholder = placeholderText?.let { placeholderText ->
                {
                    Text(
                        text = placeholderText,
                        color = Color.Black.copy(alpha = 0.5f),
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            singleLine = true,
            visualTransformation = visualTransformation,
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = keyboardType,
                imeAction = ImeAction.Done
            ),
            shape = shape,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black, //todo add support for dark theme
                backgroundColor = Color.White //todo add support for dark theme
            ),
            textStyle = MaterialTheme.typography.subtitle2
        )
        error?.let {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 12.dp, end = 12.dp),
                text = it,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                fontSize = 12.sp,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Composable
private fun TravellerTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape =
        MaterialTheme.shapes.small.copy(bottomEnd = ZeroCornerSize, bottomStart = ZeroCornerSize),
    colors: TextFieldColors = TextFieldDefaults.textFieldColors()
) {
    // If color is not provided via the text style, use content color as a default
    val textColor = textStyle.color.takeOrElse {
        colors.textColor(enabled).value
    }
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))

    @OptIn(ExperimentalMaterialApi::class)
    BasicTextField(
        value = value,
        modifier = modifier
            .background(colors.backgroundColor(enabled).value, shape)
            .defaultMinSize(
                minWidth = TextFieldDefaults.MinWidth,
                minHeight = TextFieldDefaults.MinHeight
            ),
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = mergedTextStyle,
        cursorBrush = SolidColor(colors.cursorColor(isError).value),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        interactionSource = interactionSource,
        singleLine = singleLine,
        maxLines = maxLines,
        decorationBox = @Composable { innerTextField ->
            // places leading icon, text field with label and placeholder, trailing icon
            TextFieldDefaults.TextFieldDecorationBox(
                value = value,
                visualTransformation = visualTransformation,
                innerTextField = innerTextField,
                placeholder = placeholder,
                label = label,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                singleLine = singleLine,
                enabled = enabled,
                isError = isError,
                interactionSource = interactionSource,
                colors = colors,
            )
        }
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TravellerInputTextFieldPreview() = TravellerTheme {
    Surface {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TravellerInputTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = "text",
                onValueChanged = { }
            )

            TravellerInputTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = "error text",
                onValueChanged = { },
                error = "It's a such long errooooooooooooooooooooooooooooooor"
            )
        }
    }
}