package com.brbx.ui_compose.components.complex.fab.toggle_disappearing_fab

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

/**
 * Defines the visual appearance and styling of the [BrbxToggleDisappearingFab] component.
 * Configures colors, dimensions, and alignment for both checked and unchecked states
 * via progress-based lambdas.
 */
@Immutable
interface BrbxToggleDisappearingFabAppearance {

    // ---------------------------------------------------------------------------
    // Container Styling
    // ---------------------------------------------------------------------------

    /**
     * The color used for the background of the FAB, based on the checked progress (0 to 1).
     */
    @Composable
    fun containerColor(): (Float) -> Color

    /**
     * The size of the FAB container, based on the checked progress (0 to 1).
     */
    @Composable
    fun containerSize(): (Float) -> Dp

    /**
     * The corner radius of the FAB container, based on the checked progress (0 to 1).
     */
    @Composable
    fun containerCornerRadius(): (Float) -> Dp

    /**
     * The alignment of the content inside the FAB when it is toggled.
     */
    @Composable
    fun contentAlignment(): Alignment

    // ---------------------------------------------------------------------------
    // Content Colors
    // ---------------------------------------------------------------------------

    /**
     * The color of the content inside the FAB when in the checked state.
     */
    @Composable
    fun checkedContentColor(): Color

    /**
     * The color of the content inside the FAB when in the unchecked state.
     */
    @Composable
    fun uncheckedContentColor(): Color
}
