package com.andyliu.attractions.attractions.hw.cathay.core.ui.system

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.system.BaseAppTheme
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.system.darkColorScheme
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.system.lightColorScheme

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider {
        BaseAppTheme(
            colorScheme = (if (darkTheme) darkColorScheme() else lightColorScheme()),
            content = content
        )
    }
}

