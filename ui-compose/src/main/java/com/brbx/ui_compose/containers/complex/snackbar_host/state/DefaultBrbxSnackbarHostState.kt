package com.brbx.ui_compose.containers.complex.snackbar_host.state

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import com.brbx.ui_compose.components.complex.snackbar.common.BrbxSnackbarConfig
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update

/**
 * Default implementation of [BrbxSnackbarController] and [BrbxSnackbarHostState].
 *
 * This state holder manages the lifecycle, queuing, and sequential display of snackbars.
 * It maintains a queue of pending [BrbxSnackbarConfig]s and coordinates with the Compose UI
 * to ensure that only one snackbar is shown at a time.
 *
 * It acts as an orchestrator between the business logic (which requests snackbars to be shown)
 * and the UI (which displays them). It specifically guarantees that the next snackbar in the
 * queue will not be displayed until the current one is dismissed and its exit animation has
 * explicitly finished.
 */
@Stable
internal class DefaultBrbxSnackbarHostState : BrbxSnackbarController, BrbxSnackbarHostState {

    override var currentSnackbar by mutableStateOf<BrbxSnackbarConfig?>(null)
        private set

    private val queueFlow = MutableStateFlow<List<BrbxSnackbarConfig>>(emptyList())

    private val exitAnimationSignal = Channel<Unit>(Channel.CONFLATED)

    override fun show(config: BrbxSnackbarConfig) {
        queueFlow.update { currentQueue -> currentQueue + config }
    }

    override fun dismissCurrent() {
        currentSnackbar = null
    }

    override fun removeById(id: Any) {
        if (currentSnackbar?.id == id) {
            dismissCurrent()
        }
        queueFlow.update { currentQueue -> currentQueue.filterNot { it.id == id } }
    }

    override fun onExitAnimationFinished() {
        exitAnimationSignal.trySend(Unit)
    }

    override suspend fun observeQueue() {
        while (true) {
            queueFlow.first { it.isNotEmpty() }

            var next: BrbxSnackbarConfig? = null
            queueFlow.update { currentQueue ->
                next = currentQueue.firstOrNull()
                if (next != null) currentQueue.drop(1) else currentQueue
            }

            if (next != null) {
                exitAnimationSignal.tryReceive()

                currentSnackbar = next

                snapshotFlow { currentSnackbar }.first { it == null }

                exitAnimationSignal.receive()
            }
        }
    }
}
