package com.andyliu.attractions.attractions.hw.cathay.core.ui.system.system

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ColorScheme(
    val primary: Color,
) {

}

internal fun lightColorScheme() = ColorScheme(
    primary = Color(0xFFE5ECF4),

)

internal fun darkColorScheme() = ColorScheme(
    primary = Color(0xFF313745),

)

internal val LocalColorScheme = staticCompositionLocalOf { lightColorScheme() }