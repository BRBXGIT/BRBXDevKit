package com.brbx.ui_compose.containers.complex.animated_border

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.brbx.ui_compose.theme.bElevation

/**
 * A collection of predefined [BrbxAnimatedBorderContainerAppearance] styles.
 */
@Immutable
object BrbxAnimatedBorderContainerAppearances {

    val default = BrbxAnimatedBorderContainerAppearance()

    val elevated = BrbxAnimatedBorderContainerAppearance(
        shadowElevation = { bElevation.small2 }
    )

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

    val rainbowElevated = BrbxAnimatedBorderContainerAppearance(
        shadowElevation = { bElevation.small2 },
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
