package com.brbx.ui_compose.state

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow

@Stable
enum class BrbxScrollDirection {
    Down, Up
}

@Stable
class BrbxScrollDirectionState(
    initialDirection: BrbxScrollDirection = BrbxScrollDirection.Up,
    private val scrollThreshold: Int = 10
) {
    var scrollDirection by mutableStateOf(initialDirection)
        private set

    private var lastScrollOffset = 0
    private var lastItemIndex = 0

    fun update(currentIndex: Int, currentOffset: Int) {
        if (currentIndex != lastItemIndex) {
            scrollDirection = if (currentIndex > lastItemIndex) {
                BrbxScrollDirection.Down
            } else {
                BrbxScrollDirection.Up
            }
            lastItemIndex = currentIndex
            lastScrollOffset = currentOffset
        } else {
            val offsetDiff = currentOffset - lastScrollOffset

            if (kotlin.math.abs(offsetDiff) >= scrollThreshold) {
                scrollDirection = if (offsetDiff > 0) {
                    BrbxScrollDirection.Down
                } else {
                    BrbxScrollDirection.Up
                }
                lastScrollOffset = currentOffset
            }
        }
    }
}

@Composable
fun rememberBrbxScrollDirectionState(
    lazyGridState: LazyGridState,
    scrollThreshold: Int = 10
): BrbxScrollDirectionState {
    val scrollState = remember { BrbxScrollDirectionState(scrollThreshold = scrollThreshold) }

    LaunchedEffect(lazyGridState) {
        snapshotFlow {
            val index = lazyGridState.firstVisibleItemIndex.toLong()
            val offset = lazyGridState.firstVisibleItemScrollOffset.toLong()
            (index shl 32) or (offset and 0xFFFFFFFFL)
        }.collect { packedLong ->
            val index = (packedLong ushr 32).toInt()
            val offset = packedLong.toInt()
            scrollState.update(currentIndex = index, currentOffset = offset)
        }
    }

    return scrollState
}

@Composable
fun rememberBrbxScrollDirectionState(
    lazyListState: LazyListState,
    scrollThreshold: Int = 10
): BrbxScrollDirectionState {
    val scrollState = remember { BrbxScrollDirectionState(scrollThreshold = scrollThreshold) }

    LaunchedEffect(lazyListState) {
        snapshotFlow {
            val index = lazyListState.firstVisibleItemIndex.toLong()
            val offset = lazyListState.firstVisibleItemScrollOffset.toLong()
            (index shl 32) or (offset and 0xFFFFFFFFL)
        }.collect { packedLong ->
            val index = (packedLong ushr 32).toInt()
            val offset = packedLong.toInt()
            scrollState.update(currentIndex = index, currentOffset = offset)
        }
    }

    return scrollState
}