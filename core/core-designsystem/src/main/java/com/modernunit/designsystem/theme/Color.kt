package com.modernunit.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private val DarkColorPalette: ColorScheme by lazy {
    darkColorScheme(
        primary = PrimaryBlue80,
        onPrimary = PrimaryBlue20,
        primaryContainer = PrimaryBlue30,
        onPrimaryContainer = PrimaryBlue90,
        secondary = SecondaryGreen80,
        onSecondary = SecondaryGreen20,
        secondaryContainer = SecondaryGreen30,
        onSecondaryContainer = SecondaryGreen90,
        tertiary = TertiaryPink80,
        onTertiary = TertiaryPink20,
        tertiaryContainer = TertiaryPink30,
        onTertiaryContainer = TertiaryPink90,
        error = ErrorRed80,
        onError = ErrorRed20,
        errorContainer = ErrorRed30,
        onErrorContainer = ErrorRed90,
        background = NeutralTeal10,
        onBackground = NeutralTeal90,
        surface = NeutralTeal10,
        onSurface = NeutralTeal80,
        surfaceVariant = NeutralVariantGrey30,
        onSurfaceVariant = NeutralVariantGrey80,
        outline = NeutralVariantGrey60
    )
}

private val LightColorPalette: ColorScheme by lazy {
    lightColorScheme(
        primary = PrimaryBlue40,
        onPrimary = PrimaryBlue100,
        primaryContainer = PrimaryBlue90,
        onPrimaryContainer = PrimaryBlue10,
        secondary = SecondaryGreen40,
        onSecondary = SecondaryGreen100,
        secondaryContainer = SecondaryGreen90,
        onSecondaryContainer = SecondaryGreen10,
        tertiary = TertiaryPink40,
        onTertiary = TertiaryPink100,
        tertiaryContainer = TertiaryPink90,
        onTertiaryContainer = TertiaryPink10,
        error = ErrorRed40,
        onError = ErrorRed100,
        errorContainer = ErrorRed90,
        onErrorContainer = ErrorRed10,
        background = NeutralTeal99,
        onBackground = NeutralTeal10,
        surface = NeutralTeal99,
        onSurface = NeutralTeal10,
        surfaceVariant = NeutralVariantGrey90,
        onSurfaceVariant = NeutralVariantGrey30,
        outline = NeutralVariantGrey50
    )
}

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
internal val PrimaryBlue100 = Color.White
// Secondary
internal val SecondaryGreen10 = Color(0xFF0C2000)
internal val SecondaryGreen20 = Color(0xFF193700)
internal val SecondaryGreen30 = Color(0xFF275000)
internal val SecondaryGreen40 = Color(0xFF3B6A11)
internal val SecondaryGreen80 = Color(0xFF9FD671)
internal val SecondaryGreen90 = Color(0xFFBAF38A)
internal val SecondaryGreen100 = Color.White
// Tertiary
internal val TertiaryPink10 = Color(0xFF3F0018)
internal val TertiaryPink20 = Color(0xFF66002B)
internal val TertiaryPink30 = Color(0xFF8F0040)
internal val TertiaryPink40 = Color(0xFFB02557)
internal val TertiaryPink80 = Color(0xFFFFB1C2)
internal val TertiaryPink90 = Color(0xFFFFD9E0)
internal val TertiaryPink100 = Color.White
// Error
internal val ErrorRed10 = Color(0xFF410002)
internal val ErrorRed20 = Color(0xFF690005)
internal val ErrorRed30 = Color(0xFF690005)
internal val ErrorRed40 = Color(0xFFBA1A1A)
internal val ErrorRed80 = Color(0xFFFFB4AB)
internal val ErrorRed90 = Color(0xFFFFDAD6)
internal val ErrorRed100 = Color.White
// Neutral
internal val NeutralTeal10 = Color(0xFF001E2D)
internal val NeutralTeal20 = Color(0xFF00344B)
internal val NeutralTeal30 = Color(0xFF004C6B)
internal val NeutralTeal40 = Color(0xFF00658D)
internal val NeutralTeal80 = Color(0xFF82CFFF)
internal val NeutralTeal90 = Color(0xFFC6E7FF)
internal val NeutralTeal99 = Color(0xFFFBFCFF)
// Neutral Variant
internal val NeutralVariantGrey10 = Color(0xFF151D20)
internal val NeutralVariantGrey20 = Color(0xFF293235)
internal val NeutralVariantGrey30 = Color(0xFF40484B)
internal val NeutralVariantGrey50 = Color(0xFF70787C)
internal val NeutralVariantGrey60 = Color(0xFF899296)
internal val NeutralVariantGrey80 = Color(0xFFBFC8CC)
internal val NeutralVariantGrey90 = Color(0xFFDBE4E8)
