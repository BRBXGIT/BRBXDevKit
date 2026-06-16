package com.brbx.mvi_compose.base_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavController
import com.brbx.mvi.view_model.BrbxMviViewModel
import com.brbx.mvi_compose.effects.BrbxEffect
import com.brbx.mvi_compose.effects.BrbxMviEffectHandler
import com.brbx.ui_compose.containers.complex.snackbar_host.composition.LocalBrbxSnackbarHostState
import com.brbx.ui_compose.containers.complex.snackbar_host.state.rememberBrbxSnackbarComponents

@Composable
fun <State, Intent : Any, LocalEffect> BrbxMviScreen(
    navController: NavController,
    viewModel: BrbxMviViewModel<State, Intent, BrbxEffect, LocalEffect>,
    content: @Composable (
        dispatchIntent: (intent: Intent) -> Unit,
        dispatchBrbxEffect: (effect: BrbxEffect) -> Unit,
        dispatchLocalEffect: (effect: LocalEffect) -> Unit,
    ) -> Unit,
) =
    BrbxMviScreenImpl(
        viewModel = viewModel,
        navController = navController,
        content = content,
    )

@Composable
private fun <State, Intent : Any, LocalEffect> BrbxMviScreenImpl(
    viewModel: BrbxMviViewModel<State, Intent, BrbxEffect, LocalEffect>,
    navController: NavController,
    content: @Composable (
        dispatchIntent: (intent: Intent) -> Unit,
        dispatchBrbxEffect: (effect: BrbxEffect) -> Unit,
        dispatchLocalEffect: (effect: LocalEffect) -> Unit,
    ) -> Unit,
) {
    val snackbarComponents = rememberBrbxSnackbarComponents()
    BrbxMviEffectHandler(
        effects = viewModel.commonEffects,
        snackbarController = snackbarComponents.controller,
        navController = navController,
    )

    CompositionLocalProvider(
        LocalBrbxSnackbarHostState provides snackbarComponents.hostState,
    ) {
        content(
            viewModel::dispatchIntent,
            viewModel::dispatchCommonEffect,
            viewModel::dispatchLocalEffect,
        )
    }
}