package com.brbx.ui_compose.components.complex.tile.tile

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bElevation
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mColors
import com.brbx.ui_compose.theme.mTypography

/**
 * Creates a new instance of
 * [com.brbx.ui_compose.components.complex.tile.tile.BrbxTileAppearance]
 * with the provided properties.
 *
 * Use this function to initialize a base appearance configuration. Since
 * this is an inline factory function, it provides a clean way to override
 * default values defined by the application theme.
 */
internal inline fun BrbxTileAppearance(
    // Container
    crossinline containerShape: @Composable () -> Shape =
        { bShapes.micro3 },
    crossinline containerBorder: @Composable () -> BorderStroke =
        { remember { BorderStroke(width = 0.dp, brush = SolidColor(value = Color.Transparent)) } },
    crossinline containerBrush: @Composable () -> Brush =
        { SolidColor(value = mColors.surfaceContainer) },
    crossinline containerContentPadding: @Composable () -> Dp =
        { bDimens.micro8 },
    crossinline containerElevation: @Composable () -> Dp =
        { bElevation.zero },
    crossinline containerElevationAmbientColor: @Composable () -> Color =
        { remember { Color.Transparent } },
    crossinline containerElevationSpotColor: @Composable () -> Color =
        { remember { Color.Transparent } },
    crossinline containerRippleColor: @Composable () -> Color =
        { mColors.onSurface },

    // Layout & Spacing
    crossinline horizontalSpacing: @Composable () -> Dp = { bDimens.micro8 },
    crossinline verticalSpacing: @Composable () -> Dp = { bDimens.micro1 },
    crossinline contentColumnSpacing: @Composable () -> Dp = { bDimens.micro8 },

    // Title & Description
    crossinline titleColor: @Composable () -> Color = { mColors.onSurface },
    crossinline descriptionColor: @Composable () -> Color = { mColors.secondary },

    // Default Typography
    crossinline defaultTitleStyle: @Composable () -> TextStyle =
        { mTypography.bodyLarge },
    crossinline defaultTitleMaxLines: @Composable () -> Int =
        { remember { 1 } },
    crossinline defaultTitleOverflow: @Composable () -> TextOverflow =
        { remember { TextOverflow.Ellipsis } },
    crossinline defaultDescriptionStyle: @Composable () -> TextStyle =
        { mTypography.bodyMedium },
    crossinline defaultDescriptionMaxLines: @Composable () -> Int =
        { remember { 2 } },
    crossinline defaultDescriptionOverflow: @Composable () -> TextOverflow =
        { remember { TextOverflow.Ellipsis } },
): BrbxTileAppearance = object : BrbxTileAppearance {

    // Container
    @Composable
    override fun containerShape(): Shape = containerShape()

    @Composable
    override fun containerBorder(): BorderStroke = containerBorder()

    @Composable
    override fun containerBrush(): Brush = containerBrush()

    @Composable
    override fun containerContentPadding(): Dp = containerContentPadding()

    @Composable
    override fun containerElevation(): Dp = containerElevation()

    @Composable
    override fun containerElevationAmbientColor(): Color = containerElevationAmbientColor()

    @Composable
    override fun containerElevationSpotColor(): Color = containerElevationSpotColor()

    @Composable
    override fun containerRippleColor(): Color = containerRippleColor()

    // Layout & Spacing
    @Composable
    override fun horizontalSpacing(): Dp = horizontalSpacing()

    @Composable
    override fun verticalSpacing(): Dp = verticalSpacing()

    @Composable
    override fun contentColumnSpacing(): Dp = contentColumnSpacing()

    // Title & Description
    @Composable
    override fun titleColor(): Color = titleColor()

    @Composable
    override fun descriptionColor(): Color = descriptionColor()

    // Default Typography
    @Composable override fun defaultTitleStyle(): TextStyle =
        defaultTitleStyle()
    @Composable override fun defaultTitleMaxLines(): Int =
        defaultTitleMaxLines()
    @Composable override fun defaultTitleOverflow(): TextOverflow =
        defaultTitleOverflow()
    @Composable override fun defaultDescriptionStyle(): TextStyle =
        defaultDescriptionStyle()
    @Composable override fun defaultDescriptionMaxLines(): Int =
        defaultDescriptionMaxLines()
    @Composable override fun defaultDescriptionOverflow(): TextOverflow =
        defaultDescriptionOverflow()
}

/**
 * Creates a new [BrbxTileAppearance] by copying properties from the
 * current instance.
 *
 * This function is useful for creating a modified version of an existing
 * appearance object without mutating the original. Note that this creates
 * a new object on every call, so it should be used carefully within
 * recomposition loops. Better use [rememberCopy] instead.
 */
@UnsafeAppearanceCopy
inline fun BrbxTileAppearance.copy(
    // Container
    crossinline containerShape: @Composable () -> Shape =
        { this.containerShape() },
    crossinline containerBorder: @Composable () -> BorderStroke =
        { this.containerBorder() },
    crossinline containerBrush: @Composable () -> Brush =
        { this.containerBrush() },
    crossinline containerContentPadding: @Composable () -> Dp =
        { this.containerContentPadding() },
    crossinline containerElevation: @Composable () -> Dp =
        { this.containerElevation() },
    crossinline containerElevationAmbientColor: @Composable () -> Color =
        { this.containerElevationAmbientColor() },
    crossinline containerElevationSpotColor: @Composable () -> Color =
        { this.containerElevationSpotColor() },
    crossinline containerRippleColor: @Composable () -> Color =
        { this.containerRippleColor() },

    // Layout & Spacing
    crossinline horizontalSpacing: @Composable () -> Dp = { this.horizontalSpacing() },
    crossinline verticalSpacing: @Composable () -> Dp = { this.verticalSpacing() },
    crossinline contentColumnSpacing: @Composable () -> Dp = { this.contentColumnSpacing() },

    // Title & Description
    crossinline titleColor: @Composable () -> Color = { this.titleColor() },
    crossinline descriptionColor: @Composable () -> Color = { this.descriptionColor() },

    // Default Typography
    crossinline defaultTitleStyle: @Composable () -> TextStyle =
        { this.defaultTitleStyle() },
    crossinline defaultTitleMaxLines: @Composable () -> Int =
        { this.defaultTitleMaxLines() },
    crossinline defaultTitleOverflow: @Composable () -> TextOverflow =
        { this.defaultTitleOverflow() },
    crossinline defaultDescriptionStyle: @Composable () -> TextStyle =
        { this.defaultDescriptionStyle() },
    crossinline defaultDescriptionMaxLines: @Composable () -> Int =
        { this.defaultDescriptionMaxLines() },
    crossinline defaultDescriptionOverflow: @Composable () -> TextOverflow =
        { this.defaultDescriptionOverflow() },
): BrbxTileAppearance = object : BrbxTileAppearance {

    // Container
    @Composable
    override fun containerShape(): Shape = containerShape()

    @Composable
    override fun containerBorder(): BorderStroke = containerBorder()

    @Composable
    override fun containerBrush(): Brush = containerBrush()

    @Composable
    override fun containerContentPadding(): Dp = containerContentPadding()

    @Composable
    override fun containerElevation(): Dp = containerElevation()

    @Composable
    override fun containerElevationAmbientColor(): Color = containerElevationAmbientColor()

    @Composable
    override fun containerElevationSpotColor(): Color = containerElevationSpotColor()

    @Composable
    override fun containerRippleColor(): Color = containerRippleColor()

    // Layout & Spacing
    @Composable
    override fun horizontalSpacing(): Dp = horizontalSpacing()

    @Composable
    override fun verticalSpacing(): Dp = verticalSpacing()

    @Composable
    override fun contentColumnSpacing(): Dp = contentColumnSpacing()

    // Title & Description
    @Composable
    override fun titleColor(): Color = titleColor()

    @Composable
    override fun descriptionColor(): Color = descriptionColor()

    // Default Typography
    @Composable override fun defaultTitleStyle(): TextStyle = defaultTitleStyle()
    @Composable override fun defaultTitleMaxLines(): Int = defaultTitleMaxLines()
    @Composable override fun defaultTitleOverflow(): TextOverflow = defaultTitleOverflow()
    @Composable override fun defaultDescriptionStyle(): TextStyle = defaultDescriptionStyle()
    @Composable override fun defaultDescriptionMaxLines(): Int = defaultDescriptionMaxLines()
    @Composable override fun defaultDescriptionOverflow(): TextOverflow = defaultDescriptionOverflow()
}

/**
 * Creates a memoized copy of the [BrbxTileAppearance] with specified
 * overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures
 * that a new [BrbxTileAppearance] object is not instantiated on every frame,
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
inline fun BrbxTileAppearance.rememberCopy(
    // Container
    crossinline containerShape: @Composable () -> Shape =
        { this.containerShape() },
    crossinline containerBorder: @Composable () -> BorderStroke =
        { this.containerBorder() },
    crossinline containerBrush: @Composable () -> Brush =
        { this.containerBrush() },
    crossinline containerContentPadding: @Composable () -> Dp =
        { this.containerContentPadding() },
    crossinline containerElevation: @Composable () -> Dp =
        { this.containerElevation() },
    crossinline containerElevationAmbientColor: @Composable () -> Color =
        { this.containerElevationAmbientColor() },
    crossinline containerElevationSpotColor: @Composable () -> Color =
        { this.containerElevationSpotColor() },
    crossinline containerRippleColor: @Composable () -> Color =
        { this.containerRippleColor() },

    // Layout & Spacing
    crossinline horizontalSpacing: @Composable () -> Dp =
        { this.horizontalSpacing() },
    crossinline verticalSpacing: @Composable () -> Dp =
        { this.verticalSpacing() },
    crossinline contentColumnSpacing: @Composable () -> Dp =
        { this.contentColumnSpacing() },

    // Title & Description
    crossinline titleColor: @Composable () -> Color = { this.titleColor() },
    crossinline descriptionColor: @Composable () -> Color = { this.descriptionColor() },

    // Default Typography
    crossinline defaultTitleStyle: @Composable () -> TextStyle =
        { this.defaultTitleStyle() },
    crossinline defaultTitleMaxLines: @Composable () -> Int =
        { this.defaultTitleMaxLines() },
    crossinline defaultTitleOverflow: @Composable () -> TextOverflow =
        { this.defaultTitleOverflow() },
    crossinline defaultDescriptionStyle: @Composable () -> TextStyle =
        { this.defaultDescriptionStyle() },
    crossinline defaultDescriptionMaxLines: @Composable () -> Int =
        { this.defaultDescriptionMaxLines() },
    crossinline defaultDescriptionOverflow: @Composable () -> TextOverflow =
        { this.defaultDescriptionOverflow() },
): BrbxTileAppearance = remember {
    this.copy(
        containerShape = containerShape,
        containerBorder = containerBorder,
        containerBrush = containerBrush,
        containerContentPadding = containerContentPadding,
        containerElevation = containerElevation,
        containerElevationAmbientColor = containerElevationAmbientColor,
        containerElevationSpotColor = containerElevationSpotColor,
        containerRippleColor = containerRippleColor,
        horizontalSpacing = horizontalSpacing,
        verticalSpacing = verticalSpacing,
        contentColumnSpacing = contentColumnSpacing,
        titleColor = titleColor,
        descriptionColor = descriptionColor,
        defaultTitleStyle = defaultTitleStyle,
        defaultTitleMaxLines = defaultTitleMaxLines,
        defaultTitleOverflow = defaultTitleOverflow,
        defaultDescriptionStyle = defaultDescriptionStyle,
        defaultDescriptionMaxLines = defaultDescriptionMaxLines,
        defaultDescriptionOverflow = defaultDescriptionOverflow,
    )
}