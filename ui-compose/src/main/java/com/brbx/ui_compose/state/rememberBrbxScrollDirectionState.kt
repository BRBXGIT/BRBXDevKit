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

/**
 * Creates and remembers a [BrbxScrollDirectionState] tied to a [LazyListState].
 *
 * It monitors changes in the list's scroll position to determine whether the container
 * is being scrolled [BrbxScrollDirection.Up] or [BrbxScrollDirection.Down].
 *
 * @param lazyListState The state of the lazy list to track.
 * @param scrollThreshold The minimum pixel offset difference required to trigger a direction change
 * when scrolling within the same item. Defaults to 10 pixels to filter out jitter.
 * @return A read-only [BrbxScrollDirectionState] to observe the scroll direction.
 */
@Composable
fun rememberBrbxScrollDirectionState(
    lazyListState: LazyListState,
    scrollThreshold: Int = 10,
    initialDirection: BrbxScrollDirection = BrbxScrollDirection.Up,
): BrbxScrollDirectionState = rememberBrbxScrollDirectionStateInternal(
    scrollThreshold = scrollThreshold,
    initialDirection = initialDirection
) {
    val index = lazyListState.firstVisibleItemIndex.toLong()
    val offset = lazyListState.firstVisibleItemScrollOffset.toLong()
    (index shl 32) or (offset and 0xFFFFFFFFL)
}

/**
 * Creates and remembers a [BrbxScrollDirectionState] tied to a [LazyGridState].
 *
 * It monitors changes in the grid's scroll position to determine whether the container
 * is being scrolled [BrbxScrollDirection.Up] or [BrbxScrollDirection.Down].
 *
 * @param lazyGridState The state of the lazy grid to track.
 * @param scrollThreshold The minimum pixel offset difference required to trigger a direction change
 * when scrolling within the same item. Defaults to 10 pixels to filter out jitter.
 * @return A read-only [BrbxScrollDirectionState] to observe the scroll direction.
 */
@Composable
fun rememberBrbxScrollDirectionState(
    lazyGridState: LazyGridState,
    scrollThreshold: Int = 10,
    initialDirection: BrbxScrollDirection = BrbxScrollDirection.Up,
): BrbxScrollDirectionState = rememberBrbxScrollDirectionStateInternal(
    scrollThreshold = scrollThreshold,
    initialDirection = initialDirection,
) {
    val index = lazyGridState.firstVisibleItemIndex.toLong()
    val offset = lazyGridState.firstVisibleItemScrollOffset.toLong()
    (index shl 32) or (offset and 0xFFFFFFFFL)
}

/**
 * An internal helper composable that manages the state lifecycle and collects scroll mutations.
 *
 * It accepts a [positionProvider] that packs the item index and scroll offset into a single [Long]
 * to avoid unnecessary object allocations during frequent `snapshotFlow` emissions.
 */
@Composable
private fun rememberBrbxScrollDirectionStateInternal(
    scrollThreshold: Int,
    initialDirection: BrbxScrollDirection,
    positionProvider: () -> Long,
): BrbxScrollDirectionState {
    val scrollState = remember {
        BrbxScrollDirectionStateImpl(
            scrollThreshold = scrollThreshold,
            initialDirection = initialDirection,
        )
    }

    LaunchedEffect(key1 = positionProvider) {
        snapshotFlow(block = positionProvider).collect { packedLong ->
            val index = (packedLong ushr 32).toInt()
            val offset = packedLong.toInt()
            scrollState.update(currentIndex = index, currentOffset = offset)
        }
    }

    return scrollState
}

/**
 * A state object that holds the current scroll direction of a scrollable container.
 *
 * This interface provides a read-only view of the direction, ensuring that external
 * components cannot artificially manipulate or update the internal scroll tracking logic.
 */
@Stable
interface BrbxScrollDirectionState {
    val scrollDirection: BrbxScrollDirection
}

/**
 * Represents the layout's scrolling direction.
 */
@Stable
enum class BrbxScrollDirection {
    Down, Up
}

/**
 * Direct implementation of [BrbxScrollDirectionState].
 *
 * Encapsulates the actual mutable state and the delta calculations used to evaluate
 * scroll direction changes based on indices and pixel thresholds.
 */
@Stable
private class BrbxScrollDirectionStateImpl(
    private val scrollThreshold: Int,
    initialDirection: BrbxScrollDirection,
) : BrbxScrollDirectionState {
    override var scrollDirection by mutableStateOf(initialDirection)
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

            if (kotlin.math.abs(n = offsetDiff) >= scrollThreshold) {
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