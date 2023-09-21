package com.andyliu.attractions.attractions.hw.cathay.core.ui.system.system

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ColorScheme(
    val primary: Color,
    val background: Color,
    val text: Text,
    val icon: Icon
) {
    @Immutable
    data class Text(
        val title: Color,
        val content: Color,
    )

    @Immutable
    data class Icon(
        val language: Color,
        val back: Color,
    )
}

internal fun lightColorScheme() = ColorScheme(
    primary = Color(0xFF0037ae),
    background = Color(0xFFFFFFFF),
    text = ColorScheme.Text(
        title = Color(0xFFFFFFFF),
        content = Color(0xFF000000),
    ),
    icon = ColorScheme.Icon(
        language = Color(0xFF000000),
        back = Color(0xFFFFFFFF),
    ),
)

internal fun darkColorScheme() = ColorScheme(
    primary = Color(0xFF313745),
    background = Color(0xFF000000),
    text = ColorScheme.Text(
        title = Color(0xFF000000),
        content = Color(0xFFFFFFFF),
    ),
    icon = ColorScheme.Icon(
        language = Color(0xFFFFFFFF),
        back = Color(0xFF000000),
    ),
)

internal val LocalColorScheme = staticCompositionLocalOf { lightColorScheme() }