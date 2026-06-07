package com.brbx.ui_compose.components.with_appearance.precollection.appearance

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp

/**
 * Defines the visual appearance and styling of the [BRBXPrecollection] component.
 * Allows flexible configuration of the component's shape, colors, paddings, and typography.
 */
@Immutable
interface BRBXPrecollectionAppearance {

    // ---------------------------------------------------------------------------
    // Container
    // ---------------------------------------------------------------------------

    /**
     * The shape of the container (e.g., rounded corners).
     */
    @Composable
    fun containerShape(): Shape

    /**
     * The background color of the container.
     */
    @Composable
    fun containerBrush(): Brush

    /**
     * The ripple color of the container.
     */
    @Composable
    fun containerRippleColor(): Color

    /**
     * The internal padding of the container (vertical and horizontal spacing).
     */
    @Composable
    fun contentPadding(): PaddingValues

    // ---------------------------------------------------------------------------
    // Typography
    // ---------------------------------------------------------------------------

    /**
     * The text style (font, size, weight) for the component's label.
     */
    @Composable
    fun textStyle(): TextStyle


    /**
     * The spacing between text and leading content.
     */
    @Composable
    fun textEndPadding(): Dp

    /**
     * Max lines of text that can be displayed.
     */
    @Composable
    fun textMaxLines(): Int

    /**
     * The style of text overflow.
     */
    @Composable
    fun textOverflow(): TextOverflow

    // ---------------------------------------------------------------------------
    // Leading content
    // ---------------------------------------------------------------------------

    /**
     * The color for leading content.
     */
    @Composable
    fun leadingContentColor(): Color
}