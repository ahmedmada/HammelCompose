package com.qader.hammelcompose.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColors(
    primary = PrimaryLight,
    secondary = SecondaryLight,
    background = BackgroundLight,
    surface = SurfaceLight,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = TextLight,
    onSurface = PrimaryButtonTextLight,
)

private val DarkColorScheme = darkColors(
    primary = PrimaryDark,
    secondary = SecondaryDark,
    background = BackgroundDark,
    surface = SurfaceDark,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = TextDark,
    onSurface = PrimaryButtonTextDark
)

//@SuppressLint("ConflictingOnColor")
//private val DarkColorScheme = darkColors(
//    primary = ThemeColors.Night.primary,
//    secondary = ThemeColors.Night.primary,
//    onPrimary = ThemeColors.Night.text,
//    surface = ThemeColors.Night.surface,
//    background = ThemeColors.Night.background,
//)
//
//@SuppressLint("ConflictingOnColor")
//private val LightColorScheme = darkColors(
//    primary = ThemeColors.Day.primary,
//    secondary = ThemeColors.Day.primary,
//    onPrimary = ThemeColors.Day.text,
//    surface = ThemeColors.Day.surface,
//    background = ThemeColors.Day.background
//)

@Composable
fun HammelComposeTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    MaterialTheme(
        typography = HammelTypography,
        content = content,
        colors = if (isDarkTheme) DarkColorScheme else LightColorScheme
    )
}
