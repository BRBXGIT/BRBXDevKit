package com.brbx.ui_compose.components.searchable_top_bar

import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset

/**
 * Defines the visual appearance and animation specs of the [BrbxSearchableTopBar] component.
 * Allows flexible configuration of the top bar's layout, colors, and search transition animations.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Immutable
interface BrbxSearchableTopBarAppearance {

    // ---------------------------------------------------------------------------
    // Container & Layout
    // ---------------------------------------------------------------------------

    /**
     * The expanded height of the top app bar.
     */
    @Composable
    fun expandedHeight(): Dp

    /**
     * The window insets applied to the top app bar.
     */
    @Composable
    fun windowInsets(): WindowInsets

    /**
     * The colors used for the background, title, and icons.
     */
    @Composable
    fun colors(): TopAppBarColors

    /**
     * The content padding applied to the top app bar.
     */
    @Composable
    fun contentPadding(): PaddingValues

    // ---------------------------------------------------------------------------
    // Animations
    // ---------------------------------------------------------------------------

    /**
     * The animation spec used for the enter spatial transitions (slide in).
     */
    @Composable
    fun enterSpatial(): FiniteAnimationSpec<IntOffset>

    /**
     * The animation spec used for the exit spatial transitions (slide out).
     */
    @Composable
    fun exitSpatial(): FiniteAnimationSpec<IntOffset>

    /**
     * The animation spec used for the alpha transitions (fade in/out).
     */
    @Composable
    fun alphaSpec(): FiniteAnimationSpec<Float>
}