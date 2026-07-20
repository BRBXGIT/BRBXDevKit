package com.brbx.ui_compose.containers.complex.animated_border.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.components.complex.shimmer.BrbxShimmerBlock
import com.brbx.ui_compose.components.complex.shimmer.BrbxShimmerBlockAppearance
import com.brbx.ui_compose.components.complex.shimmer.BrbxShimmerBlockAppearances
import com.brbx.ui_compose.containers.complex.animated_border.animated_border.BrbxAnimatedBorderContainer
import com.brbx.ui_compose.containers.complex.animated_border.animated_border.BrbxAnimatedBorderContainerAppearance
import com.brbx.ui_compose.containers.complex.animated_border.animated_border.BrbxAnimatedBorderContainerAppearances

/**
 * A shimmer placeholder for the [BrbxAnimatedBorderContainer].
 *
 * This component mimics the structure and appearance of the animated border container
 * while displaying a pulsing loading effect.
 *
 * @param modifier The modifier to be applied to the container.
 * @param appearance The visual appearance configuration, typically matching the target container.
 * @param shimmerAppearance The configuration for the pulsing shimmer effect.
 * @param content The content to be displayed inside the shimmer block.
 */
@Composable
fun BrbxAnimatedBorderContainerShimmer(
    modifier: Modifier = Modifier,
    appearance: BrbxAnimatedBorderContainerAppearance =
        BrbxAnimatedBorderContainerAppearances.primary,
    shimmerAppearance: BrbxShimmerBlockAppearance = BrbxShimmerBlockAppearances.default,
    content: @Composable BoxScope.() -> Unit = {},
) =
    BrbxAnimatedBorderContainerShimmerImpl(
        modifier = modifier,
        appearance = appearance,
        shimmerAppearance = shimmerAppearance,
        content = content,
    )

@Composable
private fun BrbxAnimatedBorderContainerShimmerImpl(
    modifier: Modifier = Modifier,
    appearance: BrbxAnimatedBorderContainerAppearance,
    shimmerAppearance: BrbxShimmerBlockAppearance,
    content: @Composable BoxScope.() -> Unit,
) {
    val shape = appearance.shape()
    val containerColor = appearance.containerColor()

    Surface(
        modifier = modifier
            .shadow(
                elevation = appearance.shadowElevation(),
                shape = shape,
                clip = false,
                ambientColor = appearance.containerElevationAmbientColor(),
                spotColor = appearance.containerElevationSpotColor(),
            ),
        shape = shape,
        color = containerColor,
        tonalElevation = appearance.tonalElevation(),
        shadowElevation = 0.dp,
        contentColor = appearance.contentColor(),
    ) {
        Box(
            modifier = Modifier.clip(shape = shape),
            contentAlignment = appearance.innerBoxAlignment(),
        ) {
            BrbxShimmerBlock(
                modifier = Modifier.matchParentSize(),
                appearance = shimmerAppearance,
            )

            Box(
                modifier = Modifier.padding(all = appearance.bordersSize()),
                contentAlignment = appearance.innerBoxAlignment(),
            ) {
                CompositionLocalProvider(
                    LocalContentColor provides appearance.contentColor(),
                    LocalTextStyle provides appearance.textStyle(),
                ) {
                    content()
                }
            }
        }
    }
}
