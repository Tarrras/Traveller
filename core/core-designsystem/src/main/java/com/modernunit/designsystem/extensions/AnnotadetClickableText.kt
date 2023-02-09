package com.modernunit.designsystem.extensions

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun AnnotatedClickableText(
    modifier: Modifier = Modifier,
    normalText: String,
    stringToBeAnnotated: String,
    onClick: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        append(normalText)
        append(' ')
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primary,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(stringToBeAnnotated)
        }
    }

    ClickableText(
        modifier = modifier,
        text = annotatedText,
        style = MaterialTheme.typography.subtitle1.copy(
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        ),
        onClick = { _ ->
            onClick()
        }
    )
}
