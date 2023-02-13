package com.modernunit.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.modernunit.designsystem.R

// Set of Material typography styles to start with
val plusJakartaSansFamily = FontFamily(
    Font(R.font.plus_jakarta_sans_regular, FontWeight.W400),
)
val rFlexFamily = FontFamily(
    Font(R.font.r_flex_regular, FontWeight.W300),
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = plusJakartaSansFamily,
        fontWeight = FontWeight.W400,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = 0.sp
    ),
    displayMedium = TextStyle(
        fontFamily = plusJakartaSansFamily,
        fontWeight = FontWeight.W400,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = plusJakartaSansFamily,
        fontWeight = FontWeight.W400,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = plusJakartaSansFamily,
        fontWeight = FontWeight.W400,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = plusJakartaSansFamily,
        fontWeight = FontWeight.W400,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = plusJakartaSansFamily,
        fontWeight = FontWeight.W400,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = plusJakartaSansFamily,
        fontWeight = FontWeight.W700,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = plusJakartaSansFamily,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (0.01).sp
    ),
    titleSmall = TextStyle(
        fontFamily = plusJakartaSansFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = (0.01).sp
    ),
    labelLarge = TextStyle(
        fontFamily = plusJakartaSansFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = (0.01).sp
    ),
    labelMedium = TextStyle(
        fontFamily = plusJakartaSansFamily,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = (0.04).sp
    ),
    labelSmall = TextStyle(
        fontFamily = plusJakartaSansFamily,
        fontWeight = FontWeight.W500,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = (0.05).sp
    ),
    bodyLarge = TextStyle(
        fontFamily = rFlexFamily,
        fontWeight = FontWeight.W300,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (0.03).sp
    ),
    bodyMedium = TextStyle(
        fontFamily = rFlexFamily,
        fontWeight = FontWeight.W300,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = (0.02).sp
    ),
    bodySmall = TextStyle(
        fontFamily = rFlexFamily,
        fontWeight = FontWeight.W300,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = (0.03).sp
    )
)
