package com.brbx.ui_compose.containers.simple.omni_swipeable_container

import androidx.compose.runtime.Immutable

/**
 * Default implementation of [BrbxSwipeConfig].
 * @property allowedDirections Defaults to allowing only horizontal swipes ([BrbxSwipeDirection.Left] and [BrbxSwipeDirection.Right]).
 * @property swipeThreshold Defaults to a threshold of 300 pixels.
 */
@Immutable
internal data class BrbxDefaultSwipeConfig(
    override val swipeThreshold: Float = 300f,
    override val allowedDirections: Set<BrbxSwipeDirection> = setOf(
        BrbxSwipeDirection.Left,
        BrbxSwipeDirection.Right
    ),
) : BrbxSwipeConfig