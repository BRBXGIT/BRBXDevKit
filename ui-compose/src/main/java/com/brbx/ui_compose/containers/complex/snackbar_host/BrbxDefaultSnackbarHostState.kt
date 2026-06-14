package com.brbx.ui_compose.containers.complex.snackbar_host

import androidx.compose.runtime.*
import com.brbx.core.effects.snackbar.BrbxSnackbarConfig
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlin.time.Duration.Companion.milliseconds

/**
 * The default implementation of [BrbxSnackbarHostState].
 * * This class uses a Kotlin Coroutines [Channel] to manage a queue of snackbars.
 * It ensures that multiple rapid calls to [show] do not overlap, but instead
 * display sequentially, waiting for the previous snackbar to be dismissed (either
 * through timeout, user swipe, or action click) before showing the next one.
 */
@Stable
internal class BrbxDefaultSnackbarHostState : BrbxSnackbarHostState {

    override var currentSnackbar by mutableStateOf<BrbxSnackbarConfig?>(null)
        private set

    private val queue = Channel<BrbxSnackbarConfig>(capacity = Channel.UNLIMITED)

    override fun show(config: BrbxSnackbarConfig) {
        queue.trySend(config)
    }

    override fun dismissCurrent() {
        currentSnackbar = null
    }

    suspend fun observeQueue() {
        for (config in queue) {
            currentSnackbar = config
            snapshotFlow { currentSnackbar }.first { it == null }
            delay(duration = 250.milliseconds)
        }
    }
}