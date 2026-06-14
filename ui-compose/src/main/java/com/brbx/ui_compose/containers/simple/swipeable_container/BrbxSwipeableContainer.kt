package com.brbx.ui_compose.containers.simple.swipeable_container

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import com.brbx.ui_compose.theme.bMotion
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.roundToInt

enum class BrbxSwipeDirection {
    Left, Right,
}

/**
 * This component tracks horizontal drag gestures. Depending on the configuration, the user
 * can either swipe the content completely off-screen, or the content will automatically snap
 * back to its original position if the swipe is disabled or the threshold is not met.
 *
 * @param modifier The [Modifier] to be applied to this container.
 * @param isSwipeable Determines if the container can be permanently swiped away.
 * If `false`, the container can still be dragged but will always return to its initial position.
 * @param swipeThreshold The minimum horizontal distance (in pixels) the user must drag
 * before the gesture is considered a successful swipe.
 * @param animationSpec The [AnimationSpec] used for both the snap-back animation
 * (if the threshold isn't met or swiping is disabled) and the swipe-away animation.
 * @param onSwiped A callback triggered when the container is successfully swiped away.
 * It provides the [BrbxSwipeDirection] detailing which way the user swiped.
 * @param content The composable content to be hosted inside the swipeable container.
 */
@Composable
fun BrbxSwipeableContainer(
    modifier: Modifier = Modifier,
    isSwipeable: Boolean = true,
    swipeThreshold: Float = 300f,
    animationSpec: AnimationSpec<Float> = bMotion.settleGestureSpec(),
    onSwiped: (swipeDirection: BrbxSwipeDirection) -> Unit = {},
    content: @Composable BoxScope.() -> Unit
) =
    BrbxSwipeableContainerImpl(
        modifier = modifier,
        isSwipeable = isSwipeable,
        swipeThreshold = swipeThreshold,
        animationSpec = animationSpec,
        onSwiped = onSwiped,
        content = content,
    )

@Composable
private fun BrbxSwipeableContainerImpl(
    modifier: Modifier,
    isSwipeable: Boolean,
    swipeThreshold: Float,
    animationSpec: AnimationSpec<Float>,
    onSwiped: (swipeDirection: BrbxSwipeDirection) -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    val offsetX = remember { Animatable(initialValue = 0f) }
    val animationScope = rememberCoroutineScope()

    Box(
        content = content,
        modifier = modifier
            .offset { IntOffset(x = offsetX.value.roundToInt(), y = 0) }
            .pointerInput(isSwipeable, swipeThreshold, animationSpec) {
                detectHorizontalDragGestures(
                    onHorizontalDrag = { change, dragAmount ->
                        change.consume()
                        animationScope.launch {
                            offsetX.snapTo(targetValue = offsetX.value + dragAmount)
                        }
                    },
                    onDragEnd = {
                        animationScope.launch {
                            if (isSwipeable && abs(x = offsetX.value) > swipeThreshold) {
                                val targetValue = if (offsetX.value > 0) {
                                    size.width.toFloat()
                                } else -size.width.toFloat()
                                offsetX.animateTo(
                                    targetValue = targetValue,
                                    animationSpec = animationSpec,
                                )
                                val swipeDirection = if (offsetX.value > 0) {
                                    BrbxSwipeDirection.Right
                                } else BrbxSwipeDirection.Left
                                onSwiped(swipeDirection)
                            } else {
                                offsetX.animateTo(
                                    targetValue = 0f,
                                    animationSpec = animationSpec,
                                )
                            }
                        }
                    }
                )
            }
    )
}