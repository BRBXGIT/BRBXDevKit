package com.brbx.ui_compose.components.complex.searchable_top_bar

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.components.complex.tile.tile.rememberCopy
import com.brbx.ui_compose.theme.bMotion
import com.brbx.ui_compose.theme.mColors
import com.brbx.ui_compose.theme.mTypography

/**
 * Creates a new instance of [BrbxSearchableTopBarAppearance] with the provided properties.
 *
 * Use this function to initialize a base appearance configuration. Since this is an inline
 * factory function, it provides a clean way to override default values defined by the application theme.
 */
@OptIn(ExperimentalMaterial3Api::class)
internal inline fun BrbxSearchableTopBarAppearance(
    // Container & Layout
    crossinline expandedHeight: @Composable () -> Dp =
        { TopAppBarDefaults.TopAppBarExpandedHeight },
    crossinline windowInsets: @Composable () -> WindowInsets =
        { TopAppBarDefaults.windowInsets },
    crossinline colors: @Composable () -> TopAppBarColors =
        { TopAppBarDefaults.topAppBarColors() },
    crossinline contentPadding: @Composable () -> PaddingValues =
        { TopAppBarDefaults.ContentPadding },

    // Default Typography & Colors
    crossinline defaultTitleStyle: @Composable () -> TextStyle =
        { mTypography.titleLarge },
    crossinline defaultSearchFieldTextStyle: @Composable () -> TextStyle =
        { mTypography.titleLarge.copy(color = mColors.onSurface) },
    crossinline defaultSearchFieldCursorBrush: @Composable () -> Brush =
        { SolidColor(value = mColors.primary) },
    crossinline defaultSearchFieldPlaceholderStyle: @Composable () -> TextStyle =
        { mTypography.bodyLarge.copy(color = mColors.onSurfaceVariant) },

    // Transitions
    crossinline searchFieldTransitionSpec: @Composable () -> (
        AnimatedContentTransitionScope<Boolean>.() -> ContentTransform
    ) = {
        val enterSpatial = bMotion.enterStructuralSpec<IntOffset>()
        val exitSpatial = bMotion.exitStructuralSpec<IntOffset>()
        val alphaSpec = bMotion.nonSpatialFastSpec<Float>()

        remember(enterSpatial, exitSpatial, alphaSpec) {
            {
                val direction = if (targetState) -1 else 1
                val enter = slideInHorizontally(
                    animationSpec = enterSpatial
                ) { (it / 2) * direction } + fadeIn(animationSpec = alphaSpec)
                val exit = slideOutHorizontally(
                    animationSpec = exitSpatial
                ) { -(it / 2) * direction } + fadeOut(animationSpec = alphaSpec)
                enter togetherWith exit
            }
        }
    },
    crossinline searchIconTransitionSpec: @Composable () -> (
        AnimatedContentTransitionScope<Boolean>.() -> ContentTransform
    ) = {
        val enterSpatial = bMotion.enterStructuralSpec<IntOffset>()
        val exitSpatial = bMotion.exitStructuralSpec<IntOffset>()
        val alphaSpec = bMotion.nonSpatialFastSpec<Float>()

        remember(enterSpatial, exitSpatial, alphaSpec) {
            {
                val direction = if (targetState) 1 else -1
                val enter = slideInVertically(
                    animationSpec = enterSpatial
                ) { (it / 2) * direction } + fadeIn(animationSpec = alphaSpec)
                val exit = slideOutVertically(
                    animationSpec = exitSpatial
                ) { -(it / 2) * direction } + fadeOut(animationSpec = alphaSpec)
                enter togetherWith exit
            }
        }
    },
): BrbxSearchableTopBarAppearance = object : BrbxSearchableTopBarAppearance {

    // Container & Layout
    @Composable override fun expandedHeight(): Dp = expandedHeight()
    @Composable override fun windowInsets(): WindowInsets = windowInsets()
    @Composable override fun colors(): TopAppBarColors = colors()
    @Composable override fun contentPadding(): PaddingValues = contentPadding()

    // Default Typography & Colors
    @Composable override fun defaultTitleStyle(): TextStyle =
        defaultTitleStyle()
    @Composable override fun defaultSearchFieldTextStyle(): TextStyle =
        defaultSearchFieldTextStyle()
    @Composable override fun defaultSearchFieldCursorBrush(): Brush =
        defaultSearchFieldCursorBrush()
    @Composable override fun defaultSearchFieldPlaceholderStyle(): TextStyle =
        defaultSearchFieldPlaceholderStyle()

    // Transitions
    @Composable override fun searchFieldTransitionSpec():
            AnimatedContentTransitionScope<Boolean>.() -> ContentTransform =
                searchFieldTransitionSpec()
    @Composable override fun searchIconTransitionSpec():
            AnimatedContentTransitionScope<Boolean>.() -> ContentTransform =
                searchIconTransitionSpec()
}

/**
 * Creates a new [BrbxSearchableTopBarAppearance] by copying properties from the
 * current instance.
 *
 * This function is useful for creating a modified version of an existing
 * appearance object without mutating the original. Note that this creates
 * a new object on every call, so it should be used carefully within
 * recomposition loops. Better use [rememberCopy] instead.
 */
@OptIn(ExperimentalMaterial3Api::class)
@UnsafeAppearanceCopy
inline fun BrbxSearchableTopBarAppearance.copy(
    // Container & Layout
    crossinline expandedHeight: @Composable () -> Dp = { this.expandedHeight() },
    crossinline windowInsets: @Composable () -> WindowInsets = { this.windowInsets() },
    crossinline colors: @Composable () -> TopAppBarColors = { this.colors() },
    crossinline contentPadding: @Composable () -> PaddingValues = { this.contentPadding() },

    // Default Typography & Colors
    crossinline defaultTitleStyle: @Composable () -> TextStyle =
        { this.defaultTitleStyle() },
    crossinline defaultSearchFieldTextStyle: @Composable () -> TextStyle =
        { this.defaultSearchFieldTextStyle() },
    crossinline defaultSearchFieldCursorBrush: @Composable () -> Brush =
        { this.defaultSearchFieldCursorBrush() },
    crossinline defaultSearchFieldPlaceholderStyle: @Composable () -> TextStyle =
        { this.defaultSearchFieldPlaceholderStyle() },

    // Transitions
    crossinline searchFieldTransitionSpec:
        @Composable () -> (AnimatedContentTransitionScope<Boolean>.() -> ContentTransform) =
            { this.searchFieldTransitionSpec() },
    crossinline searchIconTransitionSpec:
        @Composable () -> (AnimatedContentTransitionScope<Boolean>.() -> ContentTransform) =
            { this.searchIconTransitionSpec() },
): BrbxSearchableTopBarAppearance = object : BrbxSearchableTopBarAppearance {

    // Container & Layout
    @Composable override fun expandedHeight(): Dp = expandedHeight()
    @Composable override fun windowInsets(): WindowInsets = windowInsets()
    @Composable override fun colors(): TopAppBarColors = colors()
    @Composable override fun contentPadding(): PaddingValues = contentPadding()

    // Default Typography & Colors
    @Composable override fun defaultTitleStyle(): TextStyle = defaultTitleStyle()
    @Composable override fun defaultSearchFieldTextStyle(): TextStyle = defaultSearchFieldTextStyle()
    @Composable override fun defaultSearchFieldCursorBrush(): Brush = defaultSearchFieldCursorBrush()
    @Composable override fun defaultSearchFieldPlaceholderStyle(): TextStyle = defaultSearchFieldPlaceholderStyle()

    // Transitions
    @Composable override fun searchFieldTransitionSpec():
            AnimatedContentTransitionScope<Boolean>.() -> ContentTransform =
                searchFieldTransitionSpec()
    @Composable override fun searchIconTransitionSpec():
            AnimatedContentTransitionScope<Boolean>.() -> ContentTransform =
                searchIconTransitionSpec()
}

/**
 * Creates a memoized copy of the [BrbxSearchableTopBarAppearance] with specified
 * overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures
 * that a new [BrbxSearchableTopBarAppearance] object is not instantiated on every frame,
 * preventing unnecessary object allocations.
 * 2. **Stability:** It preserves the instance across recompositions as long as
 * the inputs (parameters) remain the same, which helps Jetpack Compose skip
 * unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic runtime
 * changes to the appearance (e.g., changing colors based on interaction
 * states).
 */
@OptIn(ExperimentalMaterial3Api::class, UnsafeAppearanceCopy::class)
@Composable
inline fun BrbxSearchableTopBarAppearance.rememberCopy(
    // Container & Layout
    crossinline expandedHeight: @Composable () -> Dp = { this.expandedHeight() },
    crossinline windowInsets: @Composable () -> WindowInsets = { this.windowInsets() },
    crossinline colors: @Composable () -> TopAppBarColors = { this.colors() },
    crossinline contentPadding: @Composable () -> PaddingValues = { this.contentPadding() },

    // Default Typography & Colors
    crossinline defaultTitleStyle: @Composable () -> TextStyle =
        { this.defaultTitleStyle() },
    crossinline defaultSearchFieldTextStyle: @Composable () -> TextStyle =
        { this.defaultSearchFieldTextStyle() },
    crossinline defaultSearchFieldCursorBrush: @Composable () -> Brush =
        { this.defaultSearchFieldCursorBrush() },
    crossinline defaultSearchFieldPlaceholderStyle: @Composable () -> TextStyle =
        { this.defaultSearchFieldPlaceholderStyle() },

    // Transitions
    crossinline searchFieldTransitionSpec:
        @Composable () -> (AnimatedContentTransitionScope<Boolean>.() -> ContentTransform) =
            { this.searchFieldTransitionSpec() },
    crossinline searchIconTransitionSpec:
        @Composable () -> (AnimatedContentTransitionScope<Boolean>.() -> ContentTransform) =
            { this.searchIconTransitionSpec() },
): BrbxSearchableTopBarAppearance = remember {
    this.copy(
        expandedHeight = expandedHeight,
        windowInsets = windowInsets,
        colors = colors,
        contentPadding = contentPadding,
        defaultTitleStyle = defaultTitleStyle,
        defaultSearchFieldTextStyle = defaultSearchFieldTextStyle,
        defaultSearchFieldCursorBrush = defaultSearchFieldCursorBrush,
        defaultSearchFieldPlaceholderStyle = defaultSearchFieldPlaceholderStyle,
        searchFieldTransitionSpec = searchFieldTransitionSpec,
        searchIconTransitionSpec = searchIconTransitionSpec,
    )
}