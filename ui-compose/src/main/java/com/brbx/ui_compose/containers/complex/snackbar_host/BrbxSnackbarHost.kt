package com.brbx.ui_compose.containers.complex.snackbar_host

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.brbx.core.effects.snackbar.BrbxSnackbarConfig
import com.brbx.core.effects.snackbar.BrbxSnackbarDuration
import com.brbx.ui_compose.components.complex.snackbar.BrbxSnackbar
import com.brbx.ui_compose.containers.complex.snackbar_host.appearance.BrbxSnackbarHostAppearance
import com.brbx.ui_compose.containers.complex.snackbar_host.appearance.BrbxSnackbarHostAppearances
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
    hostState: BrbxSnackbarHostState,
    modifier: Modifier = Modifier,
    appearance: BrbxSnackbarHostAppearance = BrbxSnackbarHostAppearances.default,
    content: @Composable AnimatedVisibilityScope.(config: BrbxSnackbarConfig) -> Unit,
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
    content: @Composable AnimatedVisibilityScope.(config: BrbxSnackbarConfig) -> Unit =
        { config ->
            BrbxSnackbar(
                config = config,
                onDismiss = { hostState.dismissCurrent() },
                modifier = Modifier.padding(horizontal = bDimens.micro8, vertical = bDimens.micro4),
            )
        },
) {
    LaunchedEffect(key1 = hostState) {
        if (hostState is BrbxDefaultSnackbarHostState) {
            hostState.observeQueue()
        }
    }

    val currentConfig = hostState.currentSnackbar

    LaunchedEffect(key1 = currentConfig) {
        if (currentConfig != null) {
            val duration = when (val duration = currentConfig.duration) {
                is BrbxSnackbarDuration.Custom -> duration.millis
                BrbxSnackbarDuration.Long -> 3000L
                BrbxSnackbarDuration.Short -> 6000L
            }
            delay(duration.milliseconds)
            hostState.dismissCurrent()
        }
    }

    AnimatedVisibility(
        visible = currentConfig != null,
        modifier = modifier,
        enter = appearance.enterTransition(),
        exit = appearance.exitTransition(),
        label = "Snackbar appearance/disappearance animation",
    ) {
        currentConfig?.let { config ->
            content(config)
        }
    }
}