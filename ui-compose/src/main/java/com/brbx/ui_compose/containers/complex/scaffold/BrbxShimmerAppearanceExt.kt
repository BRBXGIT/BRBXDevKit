package com.brbx.ui_compose.containers.complex.scaffold

import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.FabPosition
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.theme.bMotion
import com.brbx.ui_compose.theme.mColors

/**
 * Creates a new instance of [BrbxShimmerScaffoldAppearance] with the provided properties.
 *
 * Use this function to initialize a base appearance configuration. Since
 * this is an inline factory function, it provides a clean way to override
 * default values defined by the application theme.
 */
internal inline fun BrbxShimmerScaffoldAppearance(
    // Colors
    crossinline containerColor: @Composable () -> Color =
        { mColors.background },
    crossinline contentColor: @Composable () -> Color =
        { contentColorFor(backgroundColor = mColors.background) },

    // Layout & Positioning
    crossinline floatingActionButtonPosition: @Composable () -> FabPosition =
        { FabPosition.End },
    crossinline contentWindowInsets: @Composable () -> WindowInsets =
        { ScaffoldDefaults.contentWindowInsets },

    // Animation & Motion
    crossinline crossfadeAnimationSpec: @Composable () -> FiniteAnimationSpec<Float> =
        { bMotion.nonSpatialMediumSpec() }
): BrbxShimmerScaffoldAppearance = object : BrbxShimmerScaffoldAppearance {

    // Colors
    @Composable
    override fun containerColor(): Color = containerColor()

    @Composable
    override fun contentColor(): Color = contentColor()

    // Layout & Positioning
    @Composable
    override fun floatingActionButtonPosition(): FabPosition = floatingActionButtonPosition()

    @Composable
    override fun contentWindowInsets(): WindowInsets = contentWindowInsets()

    // Animation & Motion
    @Composable
    override fun crossfadeAnimationSpec(): FiniteAnimationSpec<Float> = crossfadeAnimationSpec()
}

/**
 * Creates a new [BrbxShimmerScaffoldAppearance] by copying properties from
 * the current instance.
 *
 * This function is useful for creating a modified version of an existing
 * appearance object without mutating the original. Note that this creates
 * a new object on every call, so it should be used carefully within
 * recomposition loops.
 *
 * Better use [rememberCopy] instead.
 */
@UnsafeAppearanceCopy
inline fun BrbxShimmerScaffoldAppearance.copy(
    // Colors
    crossinline containerColor: @Composable () -> Color =
        { this.containerColor() },
    crossinline contentColor: @Composable () -> Color =
        { this.contentColor() },

    // Layout & Positioning
    crossinline floatingActionButtonPosition: @Composable () -> FabPosition =
        { this.floatingActionButtonPosition() },
    crossinline contentWindowInsets: @Composable () -> WindowInsets =
        { this.contentWindowInsets() },

    // Animation & Motion
    crossinline crossfadeAnimationSpec: @Composable () -> FiniteAnimationSpec<Float> =
        { this.crossfadeAnimationSpec() }
): BrbxShimmerScaffoldAppearance = object : BrbxShimmerScaffoldAppearance {

    // Colors
    @Composable override fun containerColor(): Color = containerColor()
    @Composable override fun contentColor(): Color = contentColor()

    // Layout & Positioning
    @Composable
    override fun floatingActionButtonPosition(): FabPosition = floatingActionButtonPosition()

    @Composable
    override fun contentWindowInsets(): WindowInsets = contentWindowInsets()

    // Animation & Motion
    @Composable
    override fun crossfadeAnimationSpec(): FiniteAnimationSpec<Float> = crossfadeAnimationSpec()
}

/**
 * Creates a memoized copy of the [BrbxShimmerScaffoldAppearance] with
 * specified overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember]
 * ensures that a new [BrbxShimmerScaffoldAppearance] object is not
 * instantiated on every frame, preventing unnecessary object
 * allocations.
 * 2. **Stability:** It preserves the instance across recompositions
 * as long as the inputs (parameters) remain the same, which helps
 * Jetpack Compose skip unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic
 * runtime changes to the appearance (e.g., changing animation specs based
 * on interaction states).
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BrbxShimmerScaffoldAppearance.rememberCopy(
    // Colors
    crossinline containerColor: @Composable () -> Color =
        { this.containerColor() },
    crossinline contentColor: @Composable () -> Color =
        { this.contentColor() },

    // Layout & Positioning
    crossinline floatingActionButtonPosition: @Composable () -> FabPosition =
        { this.floatingActionButtonPosition() },
    crossinline contentWindowInsets: @Composable () -> WindowInsets =
        { this.contentWindowInsets() },

    // Animation & Motion
    crossinline crossfadeAnimationSpec: @Composable () -> FiniteAnimationSpec<Float> =
        { this.crossfadeAnimationSpec() }
): BrbxShimmerScaffoldAppearance = remember {
    this.copy(
        containerColor = containerColor,
        contentColor = contentColor,
        floatingActionButtonPosition = floatingActionButtonPosition,
        contentWindowInsets = contentWindowInsets,
        crossfadeAnimationSpec = crossfadeAnimationSpec
    )
}