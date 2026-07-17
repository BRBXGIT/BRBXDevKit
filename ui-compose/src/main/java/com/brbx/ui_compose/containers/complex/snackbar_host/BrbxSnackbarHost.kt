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
import com.brbx.ui_compose.components.complex.snackbar.common.BrbxSnackbarConfig
import com.brbx.ui_compose.components.complex.snackbar.common.BrbxSnackbarDuration
import com.brbx.ui_compose.components.complex.snackbar.loading_snackbar.BrbxLoadingSnackbar
import com.brbx.ui_compose.components.complex.snackbar.loading_snackbar.config.BrbxLoadingSnackbarConfig
import com.brbx.ui_compose.components.complex.snackbar.snackbar.BrbxInfoSnackbar
import com.brbx.ui_compose.components.complex.snackbar.snackbar.config.BrbxInfoSnackbarConfig
import com.brbx.ui_compose.containers.complex.snackbar_host.appearance.BrbxSnackbarHostAppearance
import com.brbx.ui_compose.containers.complex.snackbar_host.appearance.BrbxSnackbarHostAppearances
import com.brbx.ui_compose.containers.complex.snackbar_host.composition.bSnackbarHost
import com.brbx.ui_compose.containers.complex.snackbar_host.state.BrbxSnackbarHostState
import com.brbx.ui_compose.theme.bDimens
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

/**
 * A host component responsible for managing and displaying a queue of snackbars.
 * It observes the [hostState] and animates the appearance and disappearance of snackbars.
 *
 * @param hostState The state object that manages the queue and lifecycle of snackbars.
 * @param modifier The [Modifier] to be applied to the host layout.
 * @param appearance A styling interface ([BrbxSnackbarHostAppearance]) dictating the enter and exit animations. Defaults to standard appearances.
 * @param content The composable content defining how the individual snackbar is rendered based on its config.
 */
@Composable
fun BrbxSnackbarHost(
    modifier: Modifier = Modifier,
    hostState: BrbxSnackbarHostState = bSnackbarHost,
    appearance: BrbxSnackbarHostAppearance = BrbxSnackbarHostAppearances.default,
    content: @Composable AnimatedVisibilityScope.(config: BrbxSnackbarConfig) -> Unit =
        { config ->
            val snackbarModifier = Modifier.padding(horizontal = bDimens.micro8, vertical = bDimens.micro4)
            when (config) {
                is BrbxInfoSnackbarConfig -> BrbxInfoSnackbar(
                    config = config,
                    onDismiss = { hostState.dismissCurrent() },
                    modifier = snackbarModifier,
                )
                is BrbxLoadingSnackbarConfig -> BrbxLoadingSnackbar(
                    config = config,
                    onDismiss = { hostState.dismissCurrent() },
                    modifier = snackbarModifier,
                )
                else -> { /* Unknown snackbar type */ }
            }
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
            if (currentConfig.duration != BrbxSnackbarDuration.Infinite) {
                val duration = currentConfig.duration.asMillis()
                delay(duration.milliseconds)
                hostState.dismissCurrent()
            }
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
        BrbxSnackbarDuration.Long -> 6000L
        BrbxSnackbarDuration.Short -> 3000L
    }
