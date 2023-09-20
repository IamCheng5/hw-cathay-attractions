package com.andyliu.attractions.attractions.hw.cathay.core.ui.system

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class BorderWidths(
    val small: Dp = 0.5.dp,
    val medium: Dp = 1.dp,
    val large: Dp = 1.5.dp,
)

internal val LocalBorderWidths = staticCompositionLocalOf { BorderWidths() }