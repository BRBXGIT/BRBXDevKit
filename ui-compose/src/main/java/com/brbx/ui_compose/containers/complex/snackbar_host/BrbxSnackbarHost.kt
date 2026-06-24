package com.brbx.ui_compose.containers.complex.snackbar_host

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.brbx.ui_compose.components.complex.snackbar.BrbxSnackbar
import com.brbx.ui_compose.components.complex.snackbar.config.BrbxSnackbarConfig
import com.brbx.ui_compose.components.complex.snackbar.config.BrbxSnackbarDuration
import com.brbx.ui_compose.containers.complex.snackbar_host.appearance.BrbxSnackbarHostAppearance
import com.brbx.ui_compose.containers.complex.snackbar_host.appearance.BrbxSnackbarHostAppearances
import com.brbx.ui_compose.containers.complex.snackbar_host.composition.bSnackbarHost
import com.brbx.ui_compose.containers.complex.snackbar_host.state.BrbxSnackbarHostState
import com.brbx.ui_compose.theme.bDimens
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

/**
 * A host component responsible for managing and displaying a queue of [com.brbx.ui_compose.components.complex.snackbar.BrbxSnackbar]s.
 * It observes the [hostState] and animates the appearance and disappearance of snackbars.
 *
 * @param hostState The state object that manages the queue and lifecycle of snackbars.
 * @param modifier The [Modifier] to be applied to the host layout.
 * @param appearance A styling interface ([BrbxSnackbarHostAppearance]) dictating the enter and exit animations. Defaults to standard appearances.
 * @param content The composable content defining how the individual snackbar is rendered.
 */
@Composable
fun BrbxSnackbarHost(
    modifier: Modifier = Modifier,
    hostState: BrbxSnackbarHostState = bSnackbarHost,
    appearance: BrbxSnackbarHostAppearance = BrbxSnackbarHostAppearances.default,
    content: @Composable AnimatedVisibilityScope.(config: BrbxSnackbarConfig) -> Unit=
        { config ->
            BrbxSnackbar(
                config = config,
                onDismiss = { hostState.dismissCurrent() },
                modifier = Modifier.padding(horizontal = bDimens.micro8, vertical = bDimens.micro4),
            )
        },
) =
    BrbxSnackbarHostImpl(
        hostState = hostState,
        modifier = modifier,
        appearance = appearance,
        content = content,
    )

@Composable
private fun BrbxSnackbarHostImpl(
    hostState: BrbxSnackbarHostState,
    modifier: Modifier,
    appearance: BrbxSnackbarHostAppearance,
    content: @Composable AnimatedVisibilityScope.(config: BrbxSnackbarConfig) -> Unit,
) {
    LaunchedEffect(key1 = hostState) {
        hostState.observeQueue()
    }

    val currentConfig = hostState.currentSnackbar
    var displayedConfig by remember { mutableStateOf(currentConfig) }

    LaunchedEffect(key1 = currentConfig) {
        if (currentConfig != null && currentConfig != displayedConfig) {
            displayedConfig = currentConfig
            val duration = currentConfig.duration.asMillis()
            delay(duration.milliseconds)
            hostState.dismissCurrent()
        }
    }

    val transition = updateTransition(
        targetState = currentConfig != null,
        label = "SnackbarTransition"
    )
    LaunchedEffect(key1 = transition.currentState, key2 = transition.targetState) {
        if (!transition.currentState && !transition.targetState) {
            if (displayedConfig != null) {
                hostState.onExitAnimationFinished()
                displayedConfig = null
            }
        }
    }

    transition.AnimatedVisibility(
        visible = { targetVisible -> targetVisible },
        modifier = modifier,
        enter = appearance.enterTransition(),
        exit = appearance.exitTransition(),
    ) {
        displayedConfig?.let { config ->
            content(config)
        }
    }
}

private fun BrbxSnackbarDuration.asMillis(): Long =
    when (this) {
        is BrbxSnackbarDuration.Custom -> this.millis
        BrbxSnackbarDuration.Infinite -> Long.MAX_VALUE
        BrbxSnackbarDuration.Long -> 3000L
        BrbxSnackbarDuration.Short -> 6000L
    }