package com.brbx.core.effects

import android.content.Intent
import android.widget.Toast
import androidx.compose.runtime.Immutable
import com.brbx.core.common.BrbxText
import com.brbx.core.effects.snackbar.BrbxSnackbarConfig
import com.brbx.core.navigation.BrbxBaseNavigationRoute

@Immutable
sealed interface BrbxEffect {

    // Snackbars
    @JvmInline
    value class ShowSnackbar(val config: BrbxSnackbarConfig) : BrbxEffect

    // Toast
    data class ShowToast(val text: BrbxText, val length: Int = Toast.LENGTH_SHORT)

    // Navigation
    @JvmInline
    value class Navigate(val route: BrbxBaseNavigationRoute) : BrbxEffect
    data object NavigateBack : BrbxEffect

    // Intents
    @JvmInline
    value class IntentTo(val intent: Intent) : BrbxEffect
}