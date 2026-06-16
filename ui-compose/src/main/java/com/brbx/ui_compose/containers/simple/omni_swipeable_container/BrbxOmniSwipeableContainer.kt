package com.brbx.ui_compose.containers.simple.omni_swipeable_container

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.VectorConverter
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import com.brbx.ui_compose.theme.bMotion
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.roundToInt

/**
 * A layout container that allows its content to be dragged and swiped in multiple directions.
 *
 * When the user drags the container beyond the [BrbxSwipeConfig.swipeThreshold] and releases it,
 * the container will animate off-screen in the swiped direction and invoke the [onSwiped] callback.
 * If the threshold is not met, or if [enabled] is false during release, it will spring back to its original position.
 *
 * @param modifier The modifier to be applied to the layout.
 * @param enabled Controls whether swipe gestures are active. If false, the container cannot be dragged.
 * @param config The configuration dictating allowed swipe directions and the minimum swipe threshold.
 * @param onSwiped Callback invoked when a successful swipe gesture is completed. Provides the resulting [BrbxSwipeDirection].
 * @param revertAnimationSpec The [AnimationSpec] used for both settling back to the center and animating off-screen.
 * @param content The composable content to be displayed inside this container.
 */
@Composable
fun BrbxOmniSwipeableContainer(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    config: BrbxSwipeConfig = BrbxDefaultSwipeConfig(),
    onSwiped: (swipeDirection: BrbxSwipeDirection) -> Unit = {},
    dismissAnimationSpec: AnimationSpec<Offset> = bMotion.nonSpatialExtraFastSpec(),
    revertAnimationSpec: AnimationSpec<Offset> = bMotion.settleGestureSpec(),
    content: @Composable BoxScope.() -> Unit
) =
    BrbxOmniSwipeableContainerImpl(
        modifier = modifier,
        enabled = enabled,
        config = config,
        onSwiped = onSwiped,
        revertAnimationSpec = revertAnimationSpec,
        dismissAnimationSpec = dismissAnimationSpec,
        content = content,
    )

@Composable
private fun BrbxOmniSwipeableContainerImpl(
    modifier: Modifier,
    enabled: Boolean,
    config: BrbxSwipeConfig,
    onSwiped: (swipeDirection: BrbxSwipeDirection) -> Unit,
    dismissAnimationSpec: AnimationSpec<Offset>,
    revertAnimationSpec: AnimationSpec<Offset>,
    content: @Composable BoxScope.() -> Unit,
) {
    val offset =
        remember { Animatable(initialValue = Offset.Zero, typeConverter = Offset.VectorConverter) }
    val scope = rememberCoroutineScope()
    val targetEnabled by rememberUpdatedState(newValue = enabled)
    Box(
        content = content,
        modifier = modifier
            .offset { IntOffset(x = offset.value.x.roundToInt(), y = offset.value.y.roundToInt()) }
            .pointerInput(key1 = config) {
                detectDragGestures(
                    onDrag = { change, dragAmount ->
                        change.consume()
                        scope.launch {
                            val newX =
                                if (config.allowsHorizontal) offset.value.x + dragAmount.x else 0f
                            val newY =
                                if (config.allowsVertical) offset.value.y + dragAmount.y else 0f
                            offset.snapTo(targetValue = Offset(x = newX, y = newY))
                        }
                    },
                    onDragEnd = {
                        scope.launch {
                            if (targetEnabled) {
                                val (targetOffset, swipeDirection) = calculateSwipeTarget(
                                    currentOffset = offset.value,
                                    config = config,
                                    containerSize = size
                                )
                                if (swipeDirection != null) {
                                    offset.animateTo(
                                        targetValue = targetOffset,
                                        animationSpec = dismissAnimationSpec,
                                    )
                                    onSwiped(swipeDirection)
                                } else {
                                    offset.animateTo(
                                        targetValue = targetOffset,
                                        animationSpec = revertAnimationSpec,
                                    )
                                }
                            } else {
                                offset.animateTo(
                                    targetValue = Offset.Zero,
                                    animationSpec = revertAnimationSpec,
                                )
                            }
                        }
                    }
                )
            }
    )
}

/**
 * Calculates the final target offset and resulting direction when a drag gesture ends.
 *
 * It determines whether the primary axis of movement was horizontal or vertical,
 * checks if the [BrbxSwipeConfig.swipeThreshold] was crossed, and ensures the direction
 * is permitted by the [config].
 *
 * @param currentOffset The physical offset of the container at the moment the drag ended.
 * @param config The swipe configuration containing allowed directions and thresholds.
 * @param containerSize The overall pixel size of the container, used to calculate how far to animate off-screen.
 * @return A [Pair] containing the [Offset] to animate towards, and the resulting [BrbxSwipeDirection] (or null if the threshold wasn't met).
 */
private fun calculateSwipeTarget(
    currentOffset: Offset,
    config: BrbxSwipeConfig,
    containerSize: IntSize
): Pair<Offset, BrbxSwipeDirection?> {
    val (x, y) = currentOffset
    val isHorizontalSwipe = abs(x) > abs(x = y)

    val safeMultiplier = 1.25f

    if (isHorizontalSwipe && abs(x) > config.swipeThreshold) {
        if (x > 0 && BrbxSwipeDirection.Right in config.allowedDirections) {
            return Offset(
                x = containerSize.width.toFloat() * safeMultiplier,
                y = y
            ) to BrbxSwipeDirection.Right
        }
        if (x < 0 && BrbxSwipeDirection.Left in config.allowedDirections) {
            return Offset(
                x = -containerSize.width.toFloat() * safeMultiplier,
                y = y
            ) to BrbxSwipeDirection.Left
        }
    } else if (!isHorizontalSwipe && abs(y) > config.swipeThreshold) {
        if (y > 0 && BrbxSwipeDirection.Down in config.allowedDirections) {
            return Offset(
                x = x,
                y = containerSize.height.toFloat() * safeMultiplier
            ) to BrbxSwipeDirection.Down
        }
        if (y < 0 && BrbxSwipeDirection.Up in config.allowedDirections) {
            return Offset(
                x = x,
                y = -containerSize.height.toFloat() * safeMultiplier
            ) to BrbxSwipeDirection.Up
        }
    }

    return Offset.Zero to null
}