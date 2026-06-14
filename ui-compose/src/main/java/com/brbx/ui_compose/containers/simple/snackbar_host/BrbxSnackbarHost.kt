package com.brbx.ui_compose.containers.simple.snackbar_host

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.brbx.core.effects.snackbar.BrbxSnackbarDuration
import com.brbx.ui_compose.components.complex.snackbar.DefaultBrbxSnackbar
import com.brbx.ui_compose.theme.bMotion
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun BrbxSnackbarHost(
    hostState: BrbxSnackbarHostState,
    modifier: Modifier = Modifier,
    enterSnackbarSpec: EnterTransition =
        scaleIn(animationSpec = bMotion.enterStructuralSpec()) +
                fadeIn(animationSpec = bMotion.nonSpatialFastSpec()),
    exitSnackbarSpec: ExitTransition =
        scaleOut(animationSpec = bMotion.exitStructuralSpec()) +
                fadeOut(animationSpec = bMotion.nonSpatialFastSpec()),
) =
    BrbxSnackbarHostImpl(
        hostState = hostState,
        modifier = modifier,
        enterSnackbarSpec = enterSnackbarSpec,
        exitSnackbarSpec = exitSnackbarSpec,
    )

// TODO Add kdoc, and base screen
@Composable
private fun BrbxSnackbarHostImpl(
    hostState: BrbxSnackbarHostState,
    modifier: Modifier,
    enterSnackbarSpec: EnterTransition,
    exitSnackbarSpec: ExitTransition,
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
        enter = enterSnackbarSpec,
        exit = exitSnackbarSpec,
        label = "Snackbar appearance/disappearance animation",
    ) {
        currentConfig?.let { config ->
            DefaultBrbxSnackbar(
                config = config,
                onDismiss = { hostState.dismissCurrent() },
            )
        }
    }
}