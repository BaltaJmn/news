package com.baltajmn.template.core.design.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White

import com.google.accompanist.systemuicontroller.rememberSystemUiController

val Gray = Color(0xFFD7D2D0)
val DarkGray = Color(0xFF525251)
val Orange = Color(0xFFFD4C2A)
val Black = Color(0xFF050504)

private val ColorPalette = ColorScheme(
    primary = Orange,
    onPrimary = White,
    primaryContainer = DarkGray,
    onPrimaryContainer = White,

    secondary = Gray,
    onSecondary = Black,
    secondaryContainer = DarkGray,
    onSecondaryContainer = White,

    tertiary = White,
    onTertiary = Black,
    tertiaryContainer = Gray,
    onTertiaryContainer = Black,

    error = Orange,
    onError = White,
    errorContainer = DarkGray,
    onErrorContainer = White,

    background = Black,
    onBackground = White,

    surface = DarkGray,
    onSurface = White,
    surfaceVariant = Gray,
    onSurfaceVariant = Black,

    outline = Gray,
    outlineVariant = DarkGray,

    inverseSurface = White,
    inverseOnSurface = Black,
    inversePrimary = Orange,

    scrim = Black,
    surfaceTint = Orange
)


@Composable
fun AppTheme(content: @Composable () -> Unit) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = ColorPalette.background.copy(alpha = 0.5f),
        darkIcons = false
    )

    MaterialTheme(
        colorScheme = ColorPalette,
        shapes = Shapes,
        content = content
    )

}
