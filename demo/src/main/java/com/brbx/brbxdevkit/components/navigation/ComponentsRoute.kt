package com.brbx.brbxdevkit.components.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.brbx.brbxdevkit.components.screen.ComponentsScreen
import com.brbx.brbxdevkit.components.view_model.ComponentsViewModel
import com.brbx.mvi_compose.base_screen.BrbxMviScreen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object ComponentsRoute

fun NavGraphBuilder.componentsScreen(
    navController: NavController,
) = composable<ComponentsRoute> {
    val viewModel: ComponentsViewModel = koinViewModel()

    BrbxMviScreen(
        navController = navController,
        viewModel = viewModel,
    ) { dispatchIntent, dispatchBrbxEffect, _ ->
        ComponentsScreen(
            dispatchIntent = dispatchIntent,
            dispatchBrbxEffect = dispatchBrbxEffect,
        )
    }
}