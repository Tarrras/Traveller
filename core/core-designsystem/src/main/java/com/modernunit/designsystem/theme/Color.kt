package com.modernunit.designsystem.theme

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

/**
 * Travellers colors.
 */
// Primary
internal val PrimaryBlue10 = Color(0xFF001F27)
internal val PrimaryBlue20 = Color(0xFF003642)
internal val PrimaryBlue30 = Color(0xFF004E5F)
internal val PrimaryBlue40 = Color(0xFF00677D)
internal val PrimaryBlue80 = Color(0xFF5AD5F9)
internal val PrimaryBlue90 = Color(0xFFB3EBFF)
// Secondary
internal val SecondaryGreen10 = Color(0xFF0C2000)
internal val SecondaryGreen20 = Color(0xFF193700)
internal val SecondaryGreen30 = Color(0xFF275000)
internal val SecondaryGreen40 = Color(0xFF3B6A11)
internal val SecondaryGreen80 = Color(0xFF9FD671)
internal val SecondaryGreen90 = Color(0xFFBAF38A)
// Tertiary
internal val TertiaryPink10 = Color(0xFF3F0018)
internal val TertiaryPink20 = Color(0xFF66002B)
internal val TertiaryPink30 = Color(0xFF8F0040)
internal val TertiaryPink40 = Color(0xFFB02557)
internal val TertiaryPink80 = Color(0xFFFFB1C2)
internal val TertiaryPink90 = Color(0xFFFFD9E0)
// Error
internal val ErrorRed10 = Color(0xFF410002)
internal val ErrorRed20 = Color(0xFF690005)
internal val ErrorRed30 = Color(0xFF690005)
internal val ErrorRed40 = Color(0xFFBA1A1A)
internal val ErrorRed80 = Color(0xFFFFB4AB)
internal val ErrorRed90 = Color(0xFFFFDAD6)
// Neutral
internal val NeutralTeal10 = Color(0xFF001E2D)
internal val NeutralTeal20 = Color(0xFF00344B)
internal val NeutralTeal30 = Color(0xFF004C6B)
internal val NeutralTeal40 = Color(0xFF00658D)
internal val NeutralTeal80 = Color(0xFF82CFFF)
internal val NeutralTeal90 = Color(0xFFC6E7FF)
// Neutral Variant
internal val NeutralVariantGrey10 = Color(0xFF151D20)
internal val NeutralVariantGrey20 = Color(0xFF293235)
internal val NeutralVariantGrey30 = Color(0xFF40484B)
internal val NeutralVariantGrey40 = Color(0xFF576063)
internal val NeutralVariantGrey80 = Color(0xFFBFC8CC)
internal val NeutralVariantGrey90 = Color(0xFFDBE4E8)
