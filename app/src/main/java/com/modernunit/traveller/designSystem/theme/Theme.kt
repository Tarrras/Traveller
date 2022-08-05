package com.modernunit.traveller.designSystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


@Composable
fun TravellerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val extendedColors = if (darkTheme) DarkExtendedColors else LightExtendedColors
    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(
            colors = getThemeColors(darkTheme),
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object TravellerTheme {
    val colors: ExtendedColors
        @Composable
        get() = LocalExtendedColors.current
}