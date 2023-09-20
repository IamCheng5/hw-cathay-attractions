package com.andyliu.attractions.attractions.hw.cathay.core.ui.system

import androidx.compose.foundation.LocalIndication
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun BaseAppTheme(
    colorScheme: ColorScheme = AppTheme.colorScheme,
    typography: Typography = AppTheme.typography,
    shapes: Shapes = AppTheme.shapes,
    borderWidths: BorderWidths = AppTheme.borderWidths,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalColorScheme provides colorScheme,
        LocalTypography provides typography,
        LocalShapes provides shapes,
        LocalBorderWidths provides borderWidths,
        LocalIndication provides rememberRipple(),
        content = content
    )
}

object AppTheme {
    val colorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current

    val borderWidths: BorderWidths
        @Composable
        @ReadOnlyComposable
        get() = LocalBorderWidths.current
}