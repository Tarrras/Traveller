package com.modernunit.traveller.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ExtendedColors(
    val facebookBlue: Color,
    val extendedGrey: Color,
    val backgroundGrey: Color,
)

val LightExtendedColors by lazy {
    ExtendedColors(
        facebookBlue = Color(0xFF3498DB),
        extendedGrey = Color(0xFFC0C0C0),
        backgroundGrey = Color(0xFFF2F2F2)
    )
}

//todo update for dark theme
val DarkExtendedColors by lazy {
    ExtendedColors(
        facebookBlue = Color(0xFF3498DB),
        extendedGrey = Color(0xFFC0C0C0),
        backgroundGrey = Color(0xFFF2F2F2)
    )
}

val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        facebookBlue = Color.Unspecified,
        extendedGrey = Color.Unspecified,
        backgroundGrey = Color.Unspecified
    )
}