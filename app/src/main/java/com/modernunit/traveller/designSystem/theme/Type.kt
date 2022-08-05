package com.modernunit.traveller.designSystem.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.modernunit.traveller.R

// Set of Material typography styles to start with
val poppinsFamily = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Bold),
)
val robotoFamily = FontFamily(
    Font(R.font.roboto, FontWeight.W400),
)
val montserratFamily = FontFamily(
    Font(R.font.montserrat_bold, FontWeight.W700),
    Font(R.font.montserrat_regular, FontWeight.W400),
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    button = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.W700,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = montserratFamily,
        fontWeight = FontWeight.W700,
        fontSize = 30.sp
    ),
    h3 = TextStyle(
        fontFamily = montserratFamily,
        fontWeight = FontWeight.W700,
        fontSize = 15.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = montserratFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    ),
)