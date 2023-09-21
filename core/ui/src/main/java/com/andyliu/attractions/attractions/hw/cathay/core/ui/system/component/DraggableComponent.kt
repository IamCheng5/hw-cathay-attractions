package com.andyliu.attractions.attractions.hw.cathay.core.ui.system.component

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt

@Composable
fun DraggableComponent(
    onPositionChange: (IntOffset) -> Unit = { _ -> },
    content: @Composable () -> Unit
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        var offset by remember { mutableStateOf(IntOffset(0, 0)) }
        val parentWidth = constraints.maxWidth
        val parentHeight = constraints.maxHeight
        Box(
            Modifier
                .offset { offset }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        val offsetX = (offset.x + dragAmount.x).coerceIn(
                            0f,
                            parentWidth - size.width.toFloat()
                        )
                        val offsetY = (offset.y + dragAmount.y).coerceIn(
                            0f,
                            parentHeight - size.height.toFloat()
                        )
                        offset = IntOffset(offsetX.roundToInt(), offsetY.roundToInt())
                        onPositionChange(offset)
                    }
                }
        ) {
            content()
        }
    }
}
