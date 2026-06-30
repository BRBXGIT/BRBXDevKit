package com.brbx.ui_compose.containers.complex.animated_border

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

/**
 * A collection of predefined [BrbxAnimatedBorderContainerAppearance] styles.
 */
@Immutable
object BrbxAnimatedBorderContainerAppearances {

    val default = BrbxAnimatedBorderContainerAppearance()

    val rainbow = BrbxAnimatedBorderContainerAppearance(
        borderColors = {
            remember {
                listOf(
                    Color(0xFFE57373),
                    Color(0xFFFFB74D),
                    Color(0xFFFFF176),
                    Color(0xFF81C784),
                    Color(0xFF64B5F6),
                    Color(0xFFBA68C8),
                )
            }
        }
    )
}
