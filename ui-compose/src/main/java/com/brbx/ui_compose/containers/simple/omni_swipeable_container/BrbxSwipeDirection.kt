package com.brbx.ui_compose.containers.simple.omni_swipeable_container

import androidx.compose.runtime.Immutable

// TODO Make TopRight, BottomLeft etc. logic
/**Represents the direction of swipe**/
@Immutable
enum class BrbxSwipeDirection {
    Left, Right, Up, Down,
}