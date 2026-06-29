package com.brbx.ui_compose.components.complex.disappearing_fab

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

/**
 * Defines the visual appearance and styling of the [BrbxDisappearingFab] component.
 * Allows flexible configuration of the FAB's shape, colors, and elevation.
 */
@Immutable
interface BrbxDisappearingFabAppearance {

    // ---------------------------------------------------------------------------
    // Container
    // ---------------------------------------------------------------------------

    /**
     * The shape of the FAB's bounds.
     */
    @Composable
    fun shape(): Shape

    /**
     * The background color of the FAB container.
     */
    @Composable
    fun containerColor(): Color

    /**
     * The color used for the content (icon, text) inside the FAB.
     */
    @Composable
    fun contentColor(): Color

    /**
     * The elevation of the FAB, which controls the size and intensity of the shadow.
     */
    @Composable
    fun elevation(): FloatingActionButtonElevation

    // ---------------------------------------------------------------------------
    // Interaction
    // ---------------------------------------------------------------------------

    /**
     * The interaction source for the FAB, which can be used to observe its state
     * (e.g., pressed, hovered, focused).
     */
    @Composable
    fun interactionSource(): MutableInteractionSource?
}
