package com.modernunit.traveller.designSystem.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color(0xFF00CEC9),
    primaryVariant = Color(0xFF1C1F22),
    secondary = Color(0xFFF8F8F8),
    background = Color(0xFF101113),
    surface = Color(0xFF101113),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    error = Color(0xFFEA4335)
)

private val LightColorPalette = lightColors(
    primary = Color(0xFF00CEC9),
    primaryVariant = Color(0xFFEAF0F4),
    secondary = Color(0xFF30353E),
    background = Color(0xFFF6F8F9),
    surface = Color(0xFFF6F8F9),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    error = Color(0xFFEA4335)
)

fun getThemeColors(isInDarkTheme: Boolean) =
    if (isInDarkTheme) DarkColorPalette else LightColorPalette