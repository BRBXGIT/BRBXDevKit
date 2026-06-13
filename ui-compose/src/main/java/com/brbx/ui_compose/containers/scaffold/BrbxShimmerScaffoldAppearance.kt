package com.brbx.ui_compose.containers.scaffold

import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.FabPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Defines the visual appearance and behavior of the [BrbxShimmerScaffold].
 * Allows configuration of colors, layout positioning, and animation dynamics.
 */
@Immutable
interface BrbxShimmerScaffoldAppearance {

    // ---------------------------------------------------------------------------
    // Colors
    // ---------------------------------------------------------------------------

    /**
     * The background color of the scaffold itself.
     */
    @Composable
    fun containerColor(): Color

    /**
     * The preferred color for content inside this scaffold.
     */
    @Composable
    fun contentColor(): Color

    // ---------------------------------------------------------------------------
    // Layout & Positioning
    // ---------------------------------------------------------------------------

    /**
     * Position of the floating action button on the screen.
     */
    @Composable
    fun floatingActionButtonPosition(): FabPosition

    /**
     * Window insets to be passed to the content slots.
     */
    @Composable
    fun contentWindowInsets(): WindowInsets

    // ---------------------------------------------------------------------------
    // Animation & Motion
    // ---------------------------------------------------------------------------

    /**
     * The specification for the crossfade animation between the shimmer state and the content/error.
     */
    @Composable
    fun crossfadeAnimationSpec(): FiniteAnimationSpec<Float>
}