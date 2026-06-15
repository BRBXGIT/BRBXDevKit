package com.brbx.mvi_compose.base_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavController
import com.brbx.mvi.view_model.BrbxMviViewModel
import com.brbx.mvi_compose.effects.BrbxEffect
import com.brbx.mvi_compose.effects.BrbxMviEffectHandler
import com.brbx.ui_compose.containers.complex.snackbar_host.state.BrbxSnackbarHostState
import com.brbx.ui_compose.containers.complex.snackbar_host.state.LocalBrbxSnackbarHostState
import com.brbx.ui_compose.containers.complex.snackbar_host.state.rememberBrbxSnackbarHostState

@Composable
fun <State, Intent : Any, LocalEffect> BrbxMviScreen(
    navController: NavController,
    viewModel: BrbxMviViewModel<State, Intent, BrbxEffect, LocalEffect>,
    snackbarHostState: BrbxSnackbarHostState = rememberBrbxSnackbarHostState(),
    content: @Composable (
        dispatchIntent: (intent: Intent) -> Unit,
        dispatchBrbxEffect: (effect: BrbxEffect) -> Unit,
        dispatchLocalEffect: (effect: LocalEffect) -> Unit,
    ) -> Unit,
) =
    BrbxMviScreenImpl(
        viewModel = viewModel,
        navController = navController,
        snackbarHostState = snackbarHostState,
        content = content,
    )

@Composable
private fun <State, Intent : Any, LocalEffect> BrbxMviScreenImpl(
    viewModel: BrbxMviViewModel<State, Intent, BrbxEffect, LocalEffect>,
    navController: NavController,
    snackbarHostState: BrbxSnackbarHostState,
    content: @Composable (
        dispatchIntent: (intent: Intent) -> Unit,
        dispatchBrbxEffect: (effect: BrbxEffect) -> Unit,
        dispatchLocalEffect: (effect: LocalEffect) -> Unit,
    ) -> Unit,
) {
    CompositionLocalProvider(
        LocalBrbxSnackbarHostState provides snackbarHostState,
    ) {
        BrbxMviEffectHandler(
            effects = viewModel.commonEffects,
            snackbarHostState = LocalBrbxSnackbarHostState.current,
            navController = navController,
        )

        content(
            viewModel::dispatchIntent,
            viewModel::dispatchCommonEffect,
            viewModel::dispatchLocalEffect,
        )
    }
}