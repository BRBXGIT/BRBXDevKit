package com.brbx.ui_compose.containers.simple.omni_swipeable_container

import androidx.compose.runtime.Immutable

/**
 * Configuration interface for a swipeable container.
 * Defines the allowed swipe directions and the threshold required to trigger a swipe action.
 */
@Immutable
interface BrbxSwipeConfig {

    val allowedDirections: Set<BrbxSwipeDirection>
    val swipeThreshold: Float
    val allowsHorizontal: Boolean
        get() = allowedDirections.contains(BrbxSwipeDirection.Left) ||
                allowedDirections.contains(BrbxSwipeDirection.Right)
    val allowsVertical: Boolean
        get() = allowedDirections.contains(BrbxSwipeDirection.Up) ||
                allowedDirections.contains(BrbxSwipeDirection.Down)
}