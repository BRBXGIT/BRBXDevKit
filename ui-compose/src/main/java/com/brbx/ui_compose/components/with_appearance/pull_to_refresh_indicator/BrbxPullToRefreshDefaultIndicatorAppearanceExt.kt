package com.brbx.ui_compose.components.with_appearance.pull_to_refresh_indicator

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.graphics.shapes.RoundedPolygon
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.components.with_appearance.tile.tile.rememberCopy
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bIntensityTokens
import com.brbx.ui_compose.theme.mColors

/**
 * Creates a new instance of [BrbxPullToRefreshDefaultIndicatorAppearance] with the provided properties.
 *
 * Use this function to initialize a base appearance configuration. Since this is an inline
 * factory function, it provides a clean way to override default values defined by the application theme.
 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
internal inline fun BrbxPullToRefreshDefaultIndicatorAppearance(
    // Sizing & Progress
    crossinline indicatorSize: @Composable () -> Dp =
        { bDimens.dp42 },
    crossinline minProgressFraction: @Composable () -> Float =
        { bIntensityTokens.intensity0 },
    crossinline maxProgressFraction: @Composable () -> Float =
        { remember { 1f } },

    // Styling & Visuals
    crossinline containerColor: @Composable () -> Color =
        { mColors.surfaceContainerHigh },
    crossinline indicatorColor: @Composable () -> Color =
        { mColors.primary },
    crossinline containerShape: @Composable () -> Shape =
        { LoadingIndicatorDefaults.containerShape },
    crossinline polygons: @Composable () -> List<RoundedPolygon> =
        { remember { LoadingIndicatorDefaults.DeterminateIndicatorPolygons } },
): BrbxPullToRefreshDefaultIndicatorAppearance =
    object : BrbxPullToRefreshDefaultIndicatorAppearance {

    // Sizing & Progress
    @Composable override fun indicatorSize(): Dp = indicatorSize()
    @Composable override fun minProgressFraction(): Float = minProgressFraction()
    @Composable override fun maxProgressFraction(): Float = maxProgressFraction()

    // Styling & Visuals
    @Composable override fun containerColor(): Color = containerColor()
    @Composable override fun indicatorColor(): Color = indicatorColor()
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun polygons(): List<RoundedPolygon> = polygons()
}

/**
 * Creates a new [BrbxPullToRefreshDefaultIndicatorAppearance] by copying properties from the current instance.
 *
 * This function is useful for creating a modified version of an existing appearance object without
 * mutating the original. Note that this creates a new object on every call, so it should be used carefully
 * within recomposition loops. Better use [rememberCopy] instead.
 */
@UnsafeAppearanceCopy
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
inline fun BrbxPullToRefreshDefaultIndicatorAppearance.copy(
    // Sizing & Progress
    crossinline indicatorSize: @Composable () -> Dp = { this.indicatorSize() },
    crossinline minProgressFraction: @Composable () -> Float = { this.minProgressFraction() },
    crossinline maxProgressFraction: @Composable () -> Float = { this.maxProgressFraction() },

    // Styling & Visuals
    crossinline containerColor: @Composable () -> Color = { this.containerColor() },
    crossinline indicatorColor: @Composable () -> Color = { this.indicatorColor() },
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline polygons: @Composable () -> List<RoundedPolygon> = { this.polygons() },
): BrbxPullToRefreshDefaultIndicatorAppearance =
    object : BrbxPullToRefreshDefaultIndicatorAppearance {

        // Sizing & Progress
        @Composable override fun indicatorSize(): Dp = indicatorSize()
        @Composable override fun minProgressFraction(): Float = minProgressFraction()
        @Composable override fun maxProgressFraction(): Float = maxProgressFraction()

        // Styling & Visuals
        @Composable override fun containerColor(): Color = containerColor()
        @Composable override fun indicatorColor(): Color = indicatorColor()
        @Composable override fun containerShape(): Shape = containerShape()
        @Composable override fun polygons(): List<RoundedPolygon> = polygons()
    }

/**
 * Creates a memoized copy of the [BrbxPullToRefreshDefaultIndicatorAppearance] with specified
 * overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures
 * that a new [BrbxPullToRefreshDefaultIndicatorAppearance] object is not instantiated on every frame,
 * preventing unnecessary object allocations.
 * 2. **Stability:** It preserves the instance across recompositions as long as
 * the inputs (parameters) remain the same, which helps Jetpack Compose skip
 * unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic runtime
 * changes to the appearance (e.g., changing colors based on interaction
 * states).
 */
@OptIn(UnsafeAppearanceCopy::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
inline fun BrbxPullToRefreshDefaultIndicatorAppearance.rememberCopy(
    // Sizing & Progress
    crossinline indicatorSize: @Composable () -> Dp = { this.indicatorSize() },
    crossinline minProgressFraction: @Composable () -> Float = { this.minProgressFraction() },
    crossinline maxProgressFraction: @Composable () -> Float = { this.maxProgressFraction() },

    // Styling & Visuals
    crossinline containerColor: @Composable () -> Color = { this.containerColor() },
    crossinline indicatorColor: @Composable () -> Color = { this.indicatorColor() },
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline polygons: @Composable () -> List<RoundedPolygon> = { this.polygons() },
): BrbxPullToRefreshDefaultIndicatorAppearance =
    remember {
        this.copy(
            indicatorSize = indicatorSize,
            minProgressFraction = minProgressFraction,
            maxProgressFraction = maxProgressFraction,
            containerColor = containerColor,
            indicatorColor = indicatorColor,
            containerShape = containerShape,
            polygons = polygons,
        )
    }