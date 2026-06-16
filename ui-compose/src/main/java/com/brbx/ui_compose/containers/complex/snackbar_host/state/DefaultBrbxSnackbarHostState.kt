package com.brbx.ui_compose.containers.complex.snackbar_host.state

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import com.brbx.ui_compose.components.complex.snackbar.config.BrbxSnackbarConfig
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.first

/**
 * The default implementation of [BrbxSnackbarHostState].
 * * This class uses a Kotlin Coroutines [Channel] to manage a queue of snackbars.
 * It ensures that multiple rapid calls to [show] do not overlap, but instead
 * display sequentially, waiting for the previous snackbar to be dismissed (either
 * through timeout, user swipe, or action click) before showing the next one.
 */
@Stable
internal class DefaultBrbxSnackbarHostState : BrbxSnackbarController, BrbxSnackbarHostState {

    override var currentSnackbar by mutableStateOf<BrbxSnackbarConfig?>(null)
        private set

    private val queue = Channel<BrbxSnackbarConfig>(capacity = Channel.UNLIMITED)

    private val exitAnimationSignal = Channel<Unit>(Channel.CONFLATED)

    override fun show(config: BrbxSnackbarConfig) {
        queue.trySend(element = config)
    }

    override fun dismissCurrent() {
        currentSnackbar = null
    }

    override fun onExitAnimationFinished() {
        exitAnimationSignal.trySend(element = Unit)
    }

    override suspend fun observeQueue() {
        for (config in queue) {
            exitAnimationSignal.tryReceive()
            currentSnackbar = config
            snapshotFlow { currentSnackbar }.first { it == null }
            exitAnimationSignal.receive()
        }
    }
}