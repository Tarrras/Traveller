package com.modernunit.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ExtendedColors(
    val neutralGrey: Color,
    val semitransparent: Color,
)

val LightExtendedColors by lazy {
    ExtendedColors(
        neutralGrey = Color(0xFFECF0F5),
        semitransparent = Color(0x66140F26)
    )
}

val DarkExtendedColors by lazy {
    ExtendedColors(
        neutralGrey = Color(0xFFECF0F5),
        semitransparent = Color(0x66140F26)
    )
}

val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        neutralGrey = Color.Unspecified,
        semitransparent = Color.Unspecified
    )
}
