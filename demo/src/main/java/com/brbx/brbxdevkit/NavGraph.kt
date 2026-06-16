package com.brbx.brbxdevkit

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.brbx.brbxdevkit.components.navigation.ComponentsRoute
import com.brbx.brbxdevkit.components.navigation.componentsScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ComponentsRoute,
    ) {
        componentsScreen(navController)
    }
}