package com.brbx.ui_compose.containers.pull_to_refresh

import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BrbxPullToRefreshContainer(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    state: PullToRefreshState = rememberPullToRefreshState(),
) {
    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = {},
        state = state,
    ) {

    }
}