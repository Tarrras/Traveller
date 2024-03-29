package com.modernunit.designsystem.base

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.modernunit.designsystem.R
import com.modernunit.designsystem.theme.TravellerTheme

@Composable
fun ConnectionLostCard(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    errorText: String = stringResource(id = R.string.no_connection_text)
) = AnimatedVisibility(
    modifier = modifier.padding(top = 20.dp),
    visible = isVisible,
    enter = slideInVertically(
        animationSpec = tween(delayMillis = 200, easing = LinearOutSlowInEasing),
        initialOffsetY = { initialOffset -> -initialOffset * 5 }
    ),
    exit = slideOutVertically(
        animationSpec = tween(delayMillis = 200, easing = LinearOutSlowInEasing),
        targetOffsetY = { targetOffsetY -> -targetOffsetY * 5 }
    )
) {
    Card(
        backgroundColor = MaterialTheme.colors.error,
        contentColor = Color.White,
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = errorText,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )
    }
}

@Preview
@Composable
fun ConnectionLostCardPreview() = TravellerTheme {
    Box(modifier = Modifier.fillMaxSize()) {
        ConnectionLostCard(
            modifier = Modifier
                .align(Alignment.TopCenter),
            isVisible = true,
            errorText = "No internet connection"
        )
    }
}
