package com.brbx.mvi_compose.effects

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.brbx.ui_compose.containers.complex.snackbar_host.state.BrbxSnackbarController
import kotlinx.coroutines.flow.SharedFlow

@Composable
internal fun BrbxMviEffectHandler(
    effects: SharedFlow<BrbxEffect>,
    snackbarController: BrbxSnackbarController,
    navController: NavController,
) =
    BrbxMviEffectHandlerImpl(
        effects = effects,
        snackbarController = snackbarController,
        navController = navController,
    )

@Composable
private fun BrbxMviEffectHandlerImpl(
    effects: SharedFlow<BrbxEffect>,
    snackbarController: BrbxSnackbarController,
    navController: NavController,
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = effects) {
        effects.collect { effect ->
            when (effect) {
                is BrbxEffect.IntentTo -> context.startActivity(effect.intent)
                is BrbxEffect.Navigate<*> -> navController.navigate(effect.route)
                is BrbxEffect.ShowSnackbar -> snackbarController.show(effect.config)
                BrbxEffect.NavigateBack -> navController.navigateUp()
                is BrbxEffect.ShowAndroidToast -> {
                    Toast.makeText(
                        context,
                        effect.text,
                        effect.length,
                    )
                }
            }
        }
    }
}