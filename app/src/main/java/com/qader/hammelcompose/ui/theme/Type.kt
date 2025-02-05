package com.qader.hammelcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.qader.hammelcompose.R

val dinFontNormal = FontFamily(
    Font(R.font.din_regular, FontWeight.Normal)
)

val dinFontMedium = FontFamily(
    Font(R.font.din_mediam, FontWeight.Medium)
)

val dinFontBold = FontFamily(
    Font(R.font.din_bold, FontWeight.Bold)
)

val HammelTypography = Typography(
    h1 = TextStyle(
        fontFamily = dinFontBold,
        fontWeight = FontWeight.Bold,
        fontSize = 57.sp,
        lineHeight = 64.sp
    ),
    h2 = TextStyle(
        fontFamily = dinFontBold,
        fontWeight = FontWeight.Bold,
        fontSize = 45.sp,
        lineHeight = 52.sp
    ),
    h3 = TextStyle(
        fontFamily = dinFontBold,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 44.sp
    ),
    h4 = TextStyle(
        fontFamily = dinFontBold,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    h5 = TextStyle(
        fontFamily = dinFontMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    h6 = TextStyle(
        fontFamily = dinFontMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = dinFontMedium,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 28.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = dinFontMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 24.sp
    ),
    body1 = TextStyle(
        fontFamily = dinFontNormal,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    body2 = TextStyle(
        fontFamily = dinFontNormal,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    button = TextStyle(
        fontFamily = dinFontMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    caption = TextStyle(
        fontFamily = dinFontMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    overline = TextStyle(
        fontFamily = dinFontMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp
    )
)
