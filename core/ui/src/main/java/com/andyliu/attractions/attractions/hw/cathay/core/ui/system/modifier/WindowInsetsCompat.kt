package com.andyliu.attractions.attractions.hw.cathay.core.ui.system.modifier

import android.os.Build
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.fundation.insets.navigationBarsCompat
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.fundation.insets.statusBarsCompat
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.fundation.insets.systemBarsCompat


fun Modifier.systemBarsPaddingCompat() = composed {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        systemBarsPadding()
    } else {
        padding(WindowInsets.systemBarsCompat.asPaddingValues())
    }
}

fun Modifier.statusBarsPaddingCompat() = composed {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        statusBarsPadding()
    } else {
        padding(WindowInsets.statusBarsCompat.asPaddingValues())
    }
}

fun Modifier.navigationBarsPaddingCompat() = composed {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        navigationBarsPadding()
    } else {
        padding(WindowInsets.navigationBarsCompat.asPaddingValues())
    }
}