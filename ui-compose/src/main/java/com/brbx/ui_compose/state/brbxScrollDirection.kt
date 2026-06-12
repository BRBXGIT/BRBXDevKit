package com.brbx.ui_compose.state

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember

enum class BrbxScrollDirection {
    Up, Down,
}

@Composable
fun LazyListState.brbxScrollDirection(): BrbxScrollDirection {
    val direction = remember {
        derivedStateOf {
            val isScrollingUp = (firstVisibleItemIndex == 0 && firstVisibleItemScrollOffset == 0) ||
                    lastScrolledBackward || !canScrollForward
            if (isScrollingUp) BrbxScrollDirection.Up else BrbxScrollDirection.Down
        }
    }.value
    return direction
}