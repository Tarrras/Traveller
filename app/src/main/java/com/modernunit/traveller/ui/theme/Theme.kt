package com.modernunit.traveller.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable


@Composable
fun TravellerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

    MaterialTheme(
        colors = getThemeColors(darkTheme),
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}