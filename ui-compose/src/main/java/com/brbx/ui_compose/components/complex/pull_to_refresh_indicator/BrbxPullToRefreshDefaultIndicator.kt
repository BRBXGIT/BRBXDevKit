package com.brbx.ui_compose.components.complex.pull_to_refresh_indicator

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A default pull-to-refresh indicator component for the BRBX design system.
 *
 * This component visualizes the pull progress and the active refreshing state using
 * [ContainedLoadingIndicator] from the Material 3 Expressive API. It supports dynamic sizing
 * based on the pull fraction and can be completely styled via [BrbxPullToRefreshDefaultIndicatorAppearance].
 *
 * @param isRefreshing Whether the refresh trigger is active and animating.
 * @param fraction The current pull progress fraction (typically from 0.0 to 1.0+).
 * @param modifier The modifier to be applied to the indicator container.
 * @param appearance The [BrbxPullToRefreshDefaultIndicatorAppearance] configuration for layout and styling.
 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BrbxPullToRefreshDefaultIndicator(
    isRefreshing: Boolean,
    fraction: Float,
    modifier: Modifier = Modifier,
    appearance: BrbxPullToRefreshDefaultIndicatorAppearance =
        BrbxPullToRefreshDefaultIndicatorAppearances.default,
) =
    BrbxPullToRefreshDefaultIndicatorImpl(
        isRefreshing = isRefreshing,
        fraction = fraction,
        modifier = modifier,
        appearance = appearance,
    )

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun BrbxPullToRefreshDefaultIndicatorImpl(
    isRefreshing: Boolean,
    fraction: Float,
    modifier: Modifier,
    appearance: BrbxPullToRefreshDefaultIndicatorAppearance,
) {
    if (isRefreshing) {
        ContainedLoadingIndicator(
            modifier = modifier.size(appearance.indicatorSize()),
            containerColor = appearance.containerColor(),
            indicatorColor = appearance.indicatorColor(),
            containerShape = appearance.containerShape(),
            polygons = appearance.polygons(),
        )
    } else {
        val minProgress = appearance.minProgressFraction()
        val maxProgress = appearance.maxProgressFraction()
        val maxSizeValue = appearance.indicatorSize().value

        val progress = fraction.coerceIn(minProgress, maxProgress)
        val dynamicSize = (fraction * maxSizeValue)
            .coerceIn(0f, maxSizeValue).dp

        ContainedLoadingIndicator(
            progress = { progress },
            modifier = modifier.size(dynamicSize),
            containerColor = appearance.containerColor(),
            indicatorColor = appearance.indicatorColor(),
            containerShape = appearance.containerShape(),
            polygons = appearance.polygons(),
        )
    }
}