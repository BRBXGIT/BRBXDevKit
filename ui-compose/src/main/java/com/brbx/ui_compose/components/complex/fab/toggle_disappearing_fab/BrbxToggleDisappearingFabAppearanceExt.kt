package com.brbx.ui_compose.components.complex.fab.toggle_disappearing_fab

import androidx.compose.material3.ToggleFloatingActionButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.theme.mColors

/**
 * Creates a new instance of [BrbxToggleDisappearingFabAppearance] with the provided properties.
 *
 * Use this function to initialize a base appearance configuration.
 */
internal inline fun BrbxToggleDisappearingFabAppearance(
    // Container Styling
    crossinline containerColor: @Composable () -> (Float) -> Color = {
        ToggleFloatingActionButtonDefaults.containerColor()
    },
    crossinline containerSize: @Composable () -> (Float) -> Dp = {
        ToggleFloatingActionButtonDefaults.containerSize()
    },
    crossinline containerCornerRadius: @Composable () -> (Float) -> Dp = {
        ToggleFloatingActionButtonDefaults.containerCornerRadius()
    },
    crossinline contentAlignment: @Composable () -> Alignment = { Alignment.TopEnd },

    // Content Colors
    crossinline checkedContentColor: @Composable () -> Color = { mColors.onPrimary },
    crossinline uncheckedContentColor: @Composable () -> Color = { mColors.onSurface },
): BrbxToggleDisappearingFabAppearance = object : BrbxToggleDisappearingFabAppearance {

    // Container Styling
    @Composable override fun containerColor(): (Float) -> Color = containerColor()
    @Composable override fun containerSize(): (Float) -> Dp = containerSize()
    @Composable override fun containerCornerRadius(): (Float) -> Dp = containerCornerRadius()
    @Composable override fun contentAlignment(): Alignment = contentAlignment()

    // Content colors
    @Composable override fun checkedContentColor(): Color = checkedContentColor()
    @Composable override fun uncheckedContentColor(): Color = uncheckedContentColor()
}

/**
 * Creates a new [BrbxToggleDisappearingFabAppearance] by copying properties from the current instance.
 */
@UnsafeAppearanceCopy
inline fun BrbxToggleDisappearingFabAppearance.copy(
    // Container Styling
    crossinline containerColor: @Composable () -> (Float) -> Color =
        { this.containerColor() },
    crossinline containerSize: @Composable () -> (Float) -> Dp =
        { this.containerSize() },
    crossinline containerCornerRadius: @Composable () -> (Float) -> Dp =
        { this.containerCornerRadius() },
    crossinline contentAlignment: @Composable () -> Alignment =
        { this.contentAlignment() },

    // Content colors
    crossinline checkedContentColor: @Composable () -> Color = { this.checkedContentColor() },
    crossinline uncheckedContentColor: @Composable () -> Color = { this.uncheckedContentColor() },
): BrbxToggleDisappearingFabAppearance = object : BrbxToggleDisappearingFabAppearance {

    // Container styling
    @Composable override fun containerColor(): (Float) -> Color = containerColor()
    @Composable override fun containerSize(): (Float) -> Dp = containerSize()
    @Composable override fun containerCornerRadius(): (Float) -> Dp = containerCornerRadius()
    @Composable override fun contentAlignment(): Alignment = contentAlignment()

    // Content colors
    @Composable override fun checkedContentColor(): Color = checkedContentColor()
    @Composable override fun uncheckedContentColor(): Color = uncheckedContentColor()
}

/**
 * Creates a memoized copy of the [BrbxToggleDisappearingFabAppearance] with specified
 * overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures
 * that a new [BrbxToggleDisappearingFabAppearance] object is not instantiated on every frame,
 * preventing unnecessary object allocations.
 * 2. **Stability:** It preserves the instance across recompositions as long as
 * the inputs (parameters) remain the same, which helps Jetpack Compose skip
 * unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic runtime
 * changes to the appearance (e.g., changing colors based on interaction
 * states).
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BrbxToggleDisappearingFabAppearance.rememberCopy(
    // Container styling
    crossinline containerColor: @Composable () -> (Float) -> Color =
        { this.containerColor() },
    crossinline containerSize: @Composable () -> (Float) -> Dp =
        { this.containerSize() },
    crossinline containerCornerRadius: @Composable () -> (Float) -> Dp =
        { this.containerCornerRadius() },
    crossinline contentAlignment: @Composable () -> Alignment =
        { this.contentAlignment() },

    // Content colors
    crossinline checkedContentColor: @Composable () -> Color =
        { this.checkedContentColor() },
    crossinline uncheckedContentColor: @Composable () -> Color =
        { this.uncheckedContentColor() },
): BrbxToggleDisappearingFabAppearance = remember {
    this.copy(
        containerColor = containerColor,
        containerSize = containerSize,
        containerCornerRadius = containerCornerRadius,
        contentAlignment = contentAlignment,
        checkedContentColor = checkedContentColor,
        uncheckedContentColor = uncheckedContentColor,
    )
}
