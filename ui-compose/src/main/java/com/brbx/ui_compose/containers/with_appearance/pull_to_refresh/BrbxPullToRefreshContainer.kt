package com.brbx.ui_compose.containers.with_appearance.pull_to_refresh

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.components.with_appearance.pull_to_refresh_indicator.BrbxPullToRefreshDefaultIndicator

// TODO Add testing tools
/**
 * A container component that implements pull-to-refresh logic with customizable animations and layout.
 * This component uses [BrbxPullToRefreshAppearance] to dictate styling, animation behavior,
 * and alignment of the refresh indicator and the main content.
 *
 * @param isRefreshing Whether the refresh action is currently in progress.
 * @param onRefresh Callback to be invoked when a refresh is triggered by the user.
 * @param modifier The modifier to be applied to the container.
 * @param appearance The theme configuration defining the animation targets, specs, and content alignment.
 * @param state The state object that manages the pull-to-refresh progress and distance.
 * @param indicator A Composable to render as the refresh indicator, receiving the current pull fraction.
 * @param content The main scrollable content of the container.
 */
@Composable
fun BrbxPullToRefreshContainer(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    appearance: BrbxPullToRefreshAppearance = BrbxPullToRefreshContainerAppearances.default,
    state: PullToRefreshState = rememberPullToRefreshState(),
    indicator: @Composable (fraction: Float) -> Unit =
        { fraction -> BrbxPullToRefreshDefaultIndicator(isRefreshing, fraction) },
    content: @Composable () -> Unit,
) =
    BrbxPullToRefreshContainerImpl(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        modifier = modifier,
        appearance = appearance,
        state = state,
        indicator = indicator,
        content = content,
    )

@Composable
private fun BrbxPullToRefreshContainerImpl(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier,
    appearance: BrbxPullToRefreshAppearance,
    state: PullToRefreshState,
    indicator: @Composable (fraction: Float) -> Unit,
    content: @Composable () -> Unit,
) {
    PullToRefreshBox(
        modifier = modifier,
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        state = state,
        indicator = {}
    ) {
        val translationAnimation by animateDpAsState(
            targetValue = (state.distanceFraction * appearance.translationTargetMultiplayer()).dp,
            animationSpec = appearance.translationAnimationSpec(),
            label = "Pull translation animation"
        )

        Column(
            verticalArrangement = appearance.contentVerticalArrangement(),
            horizontalAlignment = appearance.contentHorizontalAlignment(),
            modifier = Modifier.graphicsLayer {
                translationY = translationAnimation.toPx()
            }
        ) {
            indicator(state.distanceFraction)
            content()
        }
    }
}