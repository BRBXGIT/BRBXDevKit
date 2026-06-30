package com.brbx.ui_compose.containers.complex.animated_border.animated_border

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.theme.bElevation
import com.brbx.ui_compose.theme.mColors

/**
 * A collection of predefined [BrbxAnimatedBorderContainerAppearance] styles.
 */
@OptIn(UnsafeAppearanceCopy::class)
@Immutable
object BrbxAnimatedBorderContainerAppearances {

    // ---------------------------------------------------------------------------
    // Primary
    // ---------------------------------------------------------------------------

    val primary = BrbxAnimatedBorderContainerAppearance()

    val primaryElevated = BrbxAnimatedBorderContainerAppearance(
        shadowElevation = { bElevation.small2 },
        containerElevationAmbientColor = { Color.Black },
        containerElevationSpotColor = { Color.Black },
    )

    val primaryRainbow = BrbxAnimatedBorderContainerAppearance(
        borderColors = { rememberRainbowColors() }
    )

    val primaryRainbowElevated = primaryElevated.copy(
        borderColors = { rememberRainbowColors() },
    )

    // ---------------------------------------------------------------------------
    // Secondary
    // ---------------------------------------------------------------------------

    val secondary = BrbxAnimatedBorderContainerAppearance(
        containerColor = { mColors.secondary },
        contentColor = { mColors.onSecondary },
    )

    val secondaryElevated = secondary.copy(
        shadowElevation = { bElevation.small2 },
        containerElevationAmbientColor = { Color.Black },
        containerElevationSpotColor = { Color.Black },
    )

    val secondaryRainbow = secondary.copy(
        borderColors = { rememberRainbowColors() },
    )

    val secondaryRainbowElevated = secondaryElevated.copy(
        borderColors = { rememberRainbowColors() },
    )

    // ---------------------------------------------------------------------------
    // Tertiary
    // ---------------------------------------------------------------------------

    val tertiary = BrbxAnimatedBorderContainerAppearance(
        containerColor = { mColors.tertiary },
        contentColor = { mColors.onTertiary },
    )

    val tertiaryElevated = tertiary.copy(
        shadowElevation = { bElevation.small2 },
        containerElevationAmbientColor = { Color.Black },
        containerElevationSpotColor = { Color.Black },
    )

    val tertiaryRainbow = tertiary.copy(
        borderColors = { rememberRainbowColors() },
    )

    val tertiaryRainbowElevated = tertiaryElevated.copy(
        borderColors = { rememberRainbowColors() },
    )

    // ---------------------------------------------------------------------------
    // Utils
    // ---------------------------------------------------------------------------

    @Composable
    private fun rememberRainbowColors(): List<Color> =
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
