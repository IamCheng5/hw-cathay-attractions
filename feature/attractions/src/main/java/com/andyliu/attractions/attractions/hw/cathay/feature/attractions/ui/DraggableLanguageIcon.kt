package com.andyliu.attractions.attractions.hw.cathay.feature.attractions.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.andyliu.attractions.attractions.hw.cathay.core.ui.R
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.component.DraggableComponent
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.modifier.clickableWithoutIndication

@Composable
internal fun DraggableLanguageIcon(onOffsetChange: (IntOffset) -> Unit, onClick: () -> Unit) {
    DraggableComponent(onPositionChange = onOffsetChange) {
        Icon(
            modifier = Modifier
                .size(40.dp)
                .clickableWithoutIndication(onClick = onClick),
            painter = painterResource(id = R.drawable.ic_language),
            contentDescription = null
        )
    }
}