package com.brbx.ui_compose.components.complex.fab.common

import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

fun Modifier.defaultFabSlideAnimation(
    visible: Boolean,
    startOffset: Int = 0,
    finishOffset: Int = 80,
): Modifier = composed {
    val hiddenOffset = with(receiver = LocalDensity.current) { finishOffset.dp.toPx() }
    val animation by animateIntOffsetAsState(targetValue = if (visible) {
            IntOffset(x = startOffset, y = startOffset)
        } else {
            IntOffset(x = startOffset, y = hiddenOffset.toInt())
        }, label = "Default fab offset animation",)
    this.offset { animation }
}