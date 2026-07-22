package com.brbx.mvi_compose.base_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavController
import com.brbx.mvi.view_model.BrbxMviViewModel
import com.brbx.mvi_compose.effects.BrbxCommonEffect
import com.brbx.mvi_compose.effects.BrbxEffect
import com.brbx.mvi_compose.effects.BrbxMviEffectHandler
import com.brbx.ui_compose.containers.complex.snackbar_host.composition.LocalBrbxSnackbarHostState
import com.brbx.ui_compose.containers.complex.snackbar_host.state.rememberBrbxSnackbarComponents
import kotlinx.coroutines.CoroutineScope

/**
 * A foundational Composable screen wrapper for the Brbx MVI architecture.
 * * This component bridges the [BrbxMviViewModel] with the UI. It automatically handles
 * common application-wide effects (such as navigation and snackbars) and provides
 * convenient dispatcher functions to the [content] block for sending intents and effects
 * back to the ViewModel.
 *
 * @param Intent The type representing user actions or UI events specific to this screen.
 * @param LocalEffect The type representing single-fire UI effects specific to this screen.
 * @param navController The [NavController] used to handle navigation events triggered by [BrbxEffect]s.
 * @param viewModel The [BrbxMviViewModel] managing the state, intents, and effects for this screen.
 * @param content The main UI content of the screen. It receives three dispatcher functions:
 * - `dispatchIntent`: Used to send user actions ([Intent]) to the ViewModel.
 * - `dispatchBrbxEffect`: Used to send common application-wide effects ([BrbxEffect]).
 * - `dispatchLocalEffect`: Used to send screen-specific effects ([LocalEffect]).
 */
@Composable
fun <Intent : Any, LocalEffect> BrbxMviScreen(
    navController: NavController,
    viewModel: BrbxMviViewModel<* ,*, Intent, BrbxCommonEffect, LocalEffect>,
    onCustomEffect: suspend CoroutineScope.(effect: BrbxCommonEffect) -> Unit = {},
    content: @Composable (
        dispatchIntent: (intent: Intent) -> Unit,
        dispatchCommonEffect: (effect: BrbxCommonEffect) -> Unit,
        dispatchLocalEffect: (effect: LocalEffect) -> Unit,
    ) -> Unit,
) =
    BrbxMviScreenImpl(
        viewModel = viewModel,
        navController = navController,
        content = content,
        onCustomEffect = onCustomEffect,
    )

@Composable
private fun <Intent : Any, LocalEffect> BrbxMviScreenImpl(
    viewModel: BrbxMviViewModel<*, *, Intent, BrbxCommonEffect, LocalEffect>,
    navController: NavController,
    onCustomEffect: suspend CoroutineScope.(effect: BrbxCommonEffect) -> Unit,
    content: @Composable (
        dispatchIntent: (intent: Intent) -> Unit,
        dispatchCommonEffect: (effect: BrbxCommonEffect) -> Unit,
        dispatchLocalEffect: (effect: LocalEffect) -> Unit,
    ) -> Unit,
) {
    val snackbarComponents = rememberBrbxSnackbarComponents()
    BrbxMviEffectHandler(
        effects = viewModel.commonEffects,
        snackbarController = snackbarComponents.controller,
        navController = navController,
        onCustomEffect = onCustomEffect,
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