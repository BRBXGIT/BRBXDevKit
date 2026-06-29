package com.brbx.ui_compose.components.complex.disappearing_fab

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.brbx.ui_compose.common.UnsafeAppearanceCopy

/**
 * Creates a new instance of [BrbxDisappearingFabAppearance] with the provided properties.
 *
 * Use this function to initialize a base appearance configuration. Since this is
 * an inline factory function, it provides a clean way to override default values.
 */
internal inline fun BrbxDisappearingFabAppearance(
    // Container
    crossinline shape: @Composable () -> Shape =
        { FloatingActionButtonDefaults.shape },
    crossinline containerColor: @Composable () -> Color =
        { FloatingActionButtonDefaults.containerColor },
    crossinline contentColor: @Composable () -> Color =
        { contentColorFor(backgroundColor = FloatingActionButtonDefaults.containerColor) },
    crossinline elevation: @Composable () -> FloatingActionButtonElevation =
        { FloatingActionButtonDefaults.elevation() },

    // Interaction
    crossinline interactionSource: @Composable () -> MutableInteractionSource? =
        { remember { null } },
): BrbxDisappearingFabAppearance = object : BrbxDisappearingFabAppearance {

    // Container
    @Composable override fun shape(): Shape = shape()
    @Composable override fun containerColor(): Color = containerColor()
    @Composable override fun contentColor(): Color = contentColor()
    @Composable override fun elevation(): FloatingActionButtonElevation = elevation()

    // Interaction
    @Composable override fun interactionSource(): MutableInteractionSource? = interactionSource()
}

/**
 * Creates a new [BrbxDisappearingFabAppearance] by copying properties from the
 * current instance.
 *
 * This function is useful for creating a modified version of an existing
 * appearance object without mutating the original.
 */
@UnsafeAppearanceCopy
inline fun BrbxDisappearingFabAppearance.copy(
    // Container
    crossinline shape: @Composable () -> Shape = { this.shape() },
    crossinline containerColor: @Composable () -> Color = { this.containerColor() },
    crossinline contentColor: @Composable () -> Color = { this.contentColor() },
    crossinline elevation: @Composable () -> FloatingActionButtonElevation = { this.elevation() },

    // Interaction
    crossinline interactionSource: @Composable () -> MutableInteractionSource? = { this.interactionSource() },
): BrbxDisappearingFabAppearance = object : BrbxDisappearingFabAppearance {

    // Container
    @Composable override fun shape(): Shape = shape()
    @Composable override fun containerColor(): Color = containerColor()
    @Composable override fun contentColor(): Color = contentColor()
    @Composable override fun elevation(): FloatingActionButtonElevation = elevation()

    // Interaction
    @Composable override fun interactionSource(): MutableInteractionSource? = interactionSource()
}

/**
 * Creates a memoized copy of the [BrbxDisappearingFabAppearance] with specified
 * overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures
 * that a new [BrbxDisappearingFabAppearance] object is not instantiated on every frame,
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
inline fun BrbxDisappearingFabAppearance.rememberCopy(
    // Container
    crossinline shape: @Composable () -> Shape = { this.shape() },
    crossinline containerColor: @Composable () -> Color = { this.containerColor() },
    crossinline contentColor: @Composable () -> Color = { this.contentColor() },
    crossinline elevation: @Composable () -> FloatingActionButtonElevation = { this.elevation() },

    // Interaction
    crossinline interactionSource: @Composable () -> MutableInteractionSource? = { this.interactionSource() },
): BrbxDisappearingFabAppearance = remember {
    this.copy(
        shape = shape,
        containerColor = containerColor,
        contentColor = contentColor,
        elevation = elevation,
        interactionSource = interactionSource,
    )
}
