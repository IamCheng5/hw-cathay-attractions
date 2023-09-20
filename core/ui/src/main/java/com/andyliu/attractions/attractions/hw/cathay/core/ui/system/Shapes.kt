package com.andyliu.attractions.attractions.hw.cathay.core.ui.system

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

class Shapes(
    val small: RoundedCornerShape = RoundedCornerShape(8.dp),
    val medium: RoundedCornerShape = RoundedCornerShape(12.dp),
    val large: RoundedCornerShape = RoundedCornerShape(16.dp),
    val extraLarge: RoundedCornerShape = RoundedCornerShape(28.dp)
)

internal val LocalShapes = staticCompositionLocalOf { Shapes() }