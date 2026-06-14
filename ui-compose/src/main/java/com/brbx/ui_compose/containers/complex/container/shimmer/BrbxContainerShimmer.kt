package com.brbx.ui_compose.containers.complex.container.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.components.complex.shimmer.BrbxShimmerBlockAppearance
import com.brbx.ui_compose.components.complex.shimmer.BrbxShimmerBlockAppearances
import com.brbx.ui_compose.components.complex.shimmer.BrbxShimmerBlock
import com.brbx.ui_compose.containers.complex.container.container_with_badge.BrbxContainerWithBadgeAppearance
import com.brbx.ui_compose.containers.complex.container.container_with_badge.BrbxContainerWithBadgeAppearances
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens

/**
 * A loading skeleton component that mimics the shape and structure of a [com.brbx.ui_compose.containers.complex.container.container_with_badge.BrbxContainerWithBadge]
 * while displaying an animated shimmer effect.
 *
 * This composable is typically used as a placeholder while the actual data for a
 * [com.brbx.ui_compose.containers.complex.container.container_with_badge.BrbxContainerWithBadge] is being fetched. It seamlessly clips a [BrbxShimmerBlock] to the
 * exact shape defined by the container's [appearance], ensuring the loading state
 * visually matches the final loaded UI.
 *
 * @param modifier The [Modifier] to be applied to the shimmer container.
 * @param appearance The visual configuration of the container being mocked. This provides
 * the shape used to clip the shimmer block. Defaults to [BrbxContainerWithBadgeAppearances.primary].
 * @param shimmerAppearance The visual configuration for the shimmer animation itself
 * (e.g., colors, animation speed, gradient width). Defaults to [BrbxShimmerBlockAppearances.default].
 * @param content An optional composable lambda to render inside the shimmer block.
 * Often left empty if the shimmer acts purely as a structural placeholder.
 */
@Composable
fun BrbxContainerShimmer(
    modifier: Modifier = Modifier,
    appearance: BrbxContainerWithBadgeAppearance = BrbxContainerWithBadgeAppearances.primary,
    shimmerAppearance: BrbxShimmerBlockAppearance = BrbxShimmerBlockAppearances.default,
    content: @Composable BoxScope.() -> Unit = {},
) =
    BrbxContainerShimmerImpl(
        modifier = modifier,
        appearance = appearance,
        shimmerAppearance = shimmerAppearance,
        content = content,
    )

@Composable
private fun BrbxContainerShimmerImpl(
    modifier: Modifier = Modifier,
    appearance: BrbxContainerWithBadgeAppearance,
    shimmerAppearance: BrbxShimmerBlockAppearance,
    content: @Composable BoxScope.() -> Unit,
) {
    BrbxShimmerBlock(
        modifier = modifier.clip(shape = appearance.containerShape()),
        appearance = shimmerAppearance,
        content = content,
    )
}

@Preview
@Composable
private fun BrbxContainerShimmerPreview() {
    BrbxTheme(darkColorScheme()) {
        BrbxContainerShimmer {
            Box(
                modifier = Modifier
                    .padding(all = bDimens.micro4)
                    .size(bDimens.macro2),
            )
        }
    }
}