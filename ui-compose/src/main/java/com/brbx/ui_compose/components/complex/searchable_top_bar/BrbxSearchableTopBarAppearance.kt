package com.brbx.ui_compose.components.complex.searchable_top_bar

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

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
    // Default Typography & Colors
    // ---------------------------------------------------------------------------

    /**
     * The text style applied to the standard title.
     */
    @Composable fun defaultTitleStyle(): TextStyle

    /**
     * The text style applied to the active search field input.
     */
    @Composable fun defaultSearchFieldTextStyle(): TextStyle

    /**
     * The brush used to draw the blinking cursor in the search field.
     */
    @Composable fun defaultSearchFieldCursorBrush(): Brush

    /**
     * The text style applied to the search field placeholder.
     */
    @Composable fun defaultSearchFieldPlaceholderStyle(): TextStyle

    // ---------------------------------------------------------------------------
    // Transitions
    // ---------------------------------------------------------------------------

    /**
     * The transition specification for swapping the title and the search field.
     */
    @Composable
    fun searchFieldTransitionSpec(): AnimatedContentTransitionScope<Boolean>.() -> ContentTransform

    /**
     * The transition specification for swapping the search icon and the close icon.
     */
    @Composable
    fun searchIconTransitionSpec(): AnimatedContentTransitionScope<Boolean>.() -> ContentTransform
}