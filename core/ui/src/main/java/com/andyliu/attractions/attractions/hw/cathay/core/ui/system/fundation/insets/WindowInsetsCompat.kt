package com.andyliu.attractions.attractions.hw.cathay.core.ui.system.fundation.insets

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Composable
fun WindowInsets.Companion.getInsets(typeMask:Int): WindowInsets {
    val view = LocalView.current.rootView
    val inset = ViewCompat.getRootWindowInsets(view)!!
    val insetSystemBar = inset.getInsetsIgnoringVisibility(typeMask)
    return with(LocalDensity.current) {
        WindowInsets(
            top = insetSystemBar.top.toDp(),
            bottom = insetSystemBar.bottom.toDp(),
            left = insetSystemBar.left.toDp(),
            right = insetSystemBar.right.toDp()
        )
    }
}

val WindowInsets.Companion.systemBarsCompat: WindowInsets
    @Composable
    get() {
        return getInsets(WindowInsetsCompat.Type.systemBars())
    }

val WindowInsets.Companion.statusBarsCompat: WindowInsets
    @Composable
    get() {
        return getInsets(WindowInsetsCompat.Type.statusBars())
    }

val WindowInsets.Companion.navigationBarsCompat: WindowInsets
    @Composable
    get() {
        return getInsets(WindowInsetsCompat.Type.navigationBars())
    }
