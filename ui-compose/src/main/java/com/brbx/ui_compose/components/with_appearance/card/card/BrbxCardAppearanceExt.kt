package com.brbx.ui_compose.components.with_appearance.card.card

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mColors
import com.brbx.ui_compose.theme.mTypography

/**
 * Creates a new instance of [com.brbx.ui_compose.components.with_appearance.card.card.BrbxContentCardAppearance]
 * with the provided properties.
 *
 * Use this function to initialize a base appearance configuration. Since this is an
 * inline factory function, it provides a clean way to override default values
 * defined by the application theme.
 */
internal inline fun BRBXContentCardAppearance(
    // Container & Interaction
    crossinline width: @Composable () -> Dp = { remember { 150.dp } },
    crossinline height: @Composable () -> Dp = { remember { 270.dp } },
    crossinline containerShape: @Composable () -> Shape = { bShapes.dp12 },
    crossinline containerBackground: @Composable () -> Brush = { SolidColor(mColors.surface) },
    crossinline containerRippleColor: @Composable () -> Color = { mColors.surface },

    // Badge Layout & Background
    crossinline badgeAlignment: @Composable () -> Alignment = { remember { Alignment.TopEnd } },
    crossinline badgeContainerColor: @Composable () -> Brush = { SolidColor(mColors.primary) },
    crossinline badgeContainerPadding: @Composable () -> PaddingValues = {
        PaddingValues(bDimens.dp8)
    },
    crossinline badgeContainerShape: @Composable () -> Shape = { bShapes.softSpikyCircle() },
    crossinline badgePadding: @Composable () -> PaddingValues = { PaddingValues(bDimens.dp8) },

    // Info Layout & Background
    crossinline infoAlignment: @Composable () -> Alignment = {
        remember { Alignment.BottomStart }
    },
    crossinline infoSpacedBy: @Composable () -> Dp = { bDimens.dp4 },
    crossinline infoBackground: @Composable () -> Brush = {
        SolidColor(mColors.tertiaryContainer)
    },
    crossinline infoPadding: @Composable () -> PaddingValues = { PaddingValues(bDimens.dp8) },

    // Typography
    crossinline titleStyle: @Composable () -> TextStyle = {
        mTypography.bodyMedium.copy(
            color = mColors.onTertiaryContainer,
            fontWeight = FontWeight.W600,
        )
    },
    crossinline titleMaxLines: @Composable () -> Int = { remember { 1 } },
    crossinline titleOverflow: @Composable () -> TextOverflow = { remember { TextOverflow.Ellipsis } },
    crossinline descriptionStyle: @Composable () -> TextStyle = {
        mTypography.labelMedium.copy(color = mColors.secondary)
    },
    crossinline descriptionOverflow: @Composable () -> TextOverflow = {
        remember { TextOverflow.Ellipsis }
    },
    crossinline descriptionMaxLines: @Composable () -> Int = { remember { 1 } },
    crossinline badgeTextStyle: @Composable () -> TextStyle = {
        mTypography.labelSmall.copy(color = mColors.onPrimary)
    },
    crossinline badgeMaxLines: @Composable () -> Int = { remember { 1 } },
    crossinline badgeOverflow: @Composable () -> TextOverflow = { remember { TextOverflow.Clip } },
    crossinline badgeTextAlign: @Composable () -> TextAlign = { remember { TextAlign.Center } },
): BrbxContentCardAppearance = object : BrbxContentCardAppearance {

    // Container & Interaction
    @Composable override fun containerWidth(): Dp = width()
    @Composable override fun containerHeight(): Dp = height()
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBackground(): Brush = containerBackground()
    @Composable override fun containerRippleColor(): Color = containerRippleColor()

    // Badge Layout & Background
    @Composable override fun badgeAlignment(): Alignment = badgeAlignment()
    @Composable override fun badgeContainerBrush(): Brush = badgeContainerColor()
    @Composable override fun badgeContainerPadding(): PaddingValues = badgeContainerPadding()
    @Composable override fun badgeContainerShape(): Shape = badgeContainerShape()
    @Composable override fun badgePadding(): PaddingValues = badgePadding()

    // Info Layout & Background
    @Composable override fun infoAlignment(): Alignment = infoAlignment()
    @Composable override fun infoSpacedBy(): Dp = infoSpacedBy()
    @Composable override fun infoBackground(): Brush = infoBackground()
    @Composable override fun infoPadding(): PaddingValues = infoPadding()

    // Typography
    @Composable override fun titleStyle(): TextStyle = titleStyle()
    @Composable override fun titleMaxLines(): Int = titleMaxLines()
    @Composable override fun titleOverflow(): TextOverflow = titleOverflow()
    @Composable override fun descriptionStyle(): TextStyle = descriptionStyle()
    @Composable override fun descriptionOverflow(): TextOverflow = descriptionOverflow()
    @Composable override fun descriptionMaxLines(): Int = descriptionMaxLines()
    @Composable override fun badgeTextStyle(): TextStyle = badgeTextStyle()
    @Composable override fun badgeMaxLines(): Int = badgeMaxLines()
    @Composable override fun badgeOverflow(): TextOverflow = badgeOverflow()
    @Composable override fun badgeTextAlign(): TextAlign = badgeTextAlign()
}

/**
 * Creates a new [BrbxContentCardAppearance] by copying properties from the current instance.
 *
 * This function is useful for creating a modified version of an existing appearance
 * object without mutating the original. Note that this creates a new object on
 * every call, so it should be used carefully within recomposition loops.
 *
 * Better use [rememberCopy] instead.
 */
@UnsafeAppearanceCopy
inline fun BrbxContentCardAppearance.copy(
    // Container & Interaction
    crossinline width: @Composable () -> Dp = { this.containerWidth() },
    crossinline height: @Composable () -> Dp = { this.containerHeight() },
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBackground: @Composable () -> Brush = { this.containerBackground() },
    crossinline containerRippleColor: @Composable () -> Color = { this.containerRippleColor() },

    // Badge Layout & Background
    crossinline badgeAlignment: @Composable () -> Alignment = { this.badgeAlignment() },
    crossinline badgeContainerBrush: @Composable () -> Brush = { this.badgeContainerBrush() },
    crossinline badgeContainerPadding: @Composable () -> PaddingValues = {
        this.badgeContainerPadding()
    },
    crossinline badgeContainerShape: @Composable () -> Shape = { this.badgeContainerShape() },
    crossinline badgePadding: @Composable () -> PaddingValues = { this.badgePadding() },

    // Info Layout & Background
    crossinline infoAlignment: @Composable () -> Alignment = { this.infoAlignment() },
    crossinline footerSpacedBy: @Composable () -> Dp = { this.infoSpacedBy() },
    crossinline footerBackground: @Composable () -> Brush = { this.infoBackground() },
    crossinline footerPadding: @Composable () -> PaddingValues = { this.infoPadding() },

    // Typography
    crossinline titleStyle: @Composable () -> TextStyle = { this.titleStyle() },
    crossinline titleMaxLines: @Composable () -> Int = { this.titleMaxLines() },
    crossinline titleOverflow: @Composable () -> TextOverflow = { this.titleOverflow() },
    crossinline descriptionStyle: @Composable () -> TextStyle = { this.descriptionStyle() },
    crossinline descriptionOverflow: @Composable () -> TextOverflow = {
        this.descriptionOverflow()
    },
    crossinline descriptionMaxLines: @Composable () -> Int = { this.descriptionMaxLines() },
    crossinline badgeTextStyle: @Composable () -> TextStyle = { this.badgeTextStyle() },
    crossinline badgeMaxLines: @Composable () -> Int = { this.badgeMaxLines() },
    crossinline badgeOverflow: @Composable () -> TextOverflow = { this.badgeOverflow() },
    crossinline badgeTextAlign: @Composable () -> TextAlign = { this.badgeTextAlign() },
): BrbxContentCardAppearance = object : BrbxContentCardAppearance {

    // Container & Interaction
    @Composable override fun containerWidth(): Dp = width()
    @Composable override fun containerHeight(): Dp = height()
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBackground(): Brush = containerBackground()
    @Composable override fun containerRippleColor(): Color = containerRippleColor()

    // Badge Layout & Background
    @Composable override fun badgeAlignment(): Alignment = badgeAlignment()
    @Composable override fun badgeContainerBrush(): Brush = badgeContainerBrush()
    @Composable override fun badgeContainerPadding(): PaddingValues = badgeContainerPadding()
    @Composable override fun badgeContainerShape(): Shape = badgeContainerShape()
    @Composable override fun badgePadding(): PaddingValues = badgePadding()

    // Info Layout & Background
    @Composable override fun infoAlignment(): Alignment = infoAlignment()
    @Composable override fun infoSpacedBy(): Dp = footerSpacedBy()
    @Composable override fun infoBackground(): Brush = footerBackground()
    @Composable override fun infoPadding(): PaddingValues = footerPadding()

    // Typography
    @Composable override fun titleStyle(): TextStyle = titleStyle()
    @Composable override fun titleMaxLines(): Int = titleMaxLines()
    @Composable override fun titleOverflow(): TextOverflow = titleOverflow()
    @Composable override fun descriptionStyle(): TextStyle = descriptionStyle()
    @Composable override fun descriptionOverflow(): TextOverflow = descriptionOverflow()
    @Composable override fun descriptionMaxLines(): Int = descriptionMaxLines()
    @Composable override fun badgeTextStyle(): TextStyle = badgeTextStyle()
    @Composable override fun badgeMaxLines(): Int = badgeMaxLines()
    @Composable override fun badgeOverflow(): TextOverflow = badgeOverflow()
    @Composable override fun badgeTextAlign(): TextAlign = badgeTextAlign()
}

/**
 * Creates a memoized copy of the [BrbxContentCardAppearance] with specified overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures that
 * a new [BrbxContentCardAppearance] object is not instantiated on every frame,
 * preventing unnecessary object allocations.
 * 2. **Stability:** It preserves the instance across recompositions as long as
 * the inputs (parameters) remain the same, which helps Jetpack Compose skip
 * unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic runtime
 * changes to the appearance (e.g., changing colors based on interaction states).
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BrbxContentCardAppearance.rememberCopy(
    // Container & Interaction
    crossinline width: @Composable () -> Dp = { this.containerWidth() },
    crossinline height: @Composable () -> Dp = { this.containerHeight() },
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBackground: @Composable () -> Brush = { this.containerBackground() },
    crossinline containerRippleColor: @Composable () -> Color = { this.containerRippleColor() },

    // Badge Layout & Background
    crossinline badgeAlignment: @Composable () -> Alignment = { this.badgeAlignment() },
    crossinline badgeContainerBrush: @Composable () -> Brush = { this.badgeContainerBrush() },
    crossinline badgeContainerPadding: @Composable () -> PaddingValues = {
        this.badgeContainerPadding()
    },
    crossinline badgeContainerShape: @Composable () -> Shape = { this.badgeContainerShape() },
    crossinline badgePadding: @Composable () -> PaddingValues = { this.badgePadding() },

    // Info Layout & Background
    crossinline infoAlignment: @Composable () -> Alignment = { this.infoAlignment() },
    crossinline footerSpacedBy: @Composable () -> Dp = { this.infoSpacedBy() },
    crossinline footerBackground: @Composable () -> Brush = { this.infoBackground() },
    crossinline footerPadding: @Composable () -> PaddingValues = { this.infoPadding() },

    // Typography
    crossinline titleStyle: @Composable () -> TextStyle = { this.titleStyle() },
    crossinline titleMaxLines: @Composable () -> Int = { this.titleMaxLines() },
    crossinline titleOverflow: @Composable () -> TextOverflow = { this.titleOverflow() },
    crossinline descriptionStyle: @Composable () -> TextStyle = { this.descriptionStyle() },
    crossinline descriptionOverflow: @Composable () -> TextOverflow = {
        this.descriptionOverflow()
    },
    crossinline descriptionMaxLines: @Composable () -> Int = { this.descriptionMaxLines() },
    crossinline badgeTextStyle: @Composable () -> TextStyle = { this.badgeTextStyle() },
    crossinline badgeMaxLines: @Composable () -> Int = { this.badgeMaxLines() },
    crossinline badgeOverflow: @Composable () -> TextOverflow = { this.badgeOverflow() },
    crossinline badgeTextAlign: @Composable () -> TextAlign = { this.badgeTextAlign() },
): BrbxContentCardAppearance = remember {
    this.copy(
        width = width,
        height = height,
        containerShape = containerShape,
        containerBackground = containerBackground,
        containerRippleColor = containerRippleColor,
        badgeAlignment = badgeAlignment,
        badgeContainerBrush = badgeContainerBrush,
        badgeContainerPadding = badgeContainerPadding,
        badgeContainerShape = badgeContainerShape,
        badgePadding = badgePadding,
        infoAlignment = infoAlignment,
        footerSpacedBy = footerSpacedBy,
        footerBackground = footerBackground,
        footerPadding = footerPadding,
        titleStyle = titleStyle,
        titleMaxLines = titleMaxLines,
        titleOverflow = titleOverflow,
        descriptionStyle = descriptionStyle,
        descriptionOverflow = descriptionOverflow,
        descriptionMaxLines = descriptionMaxLines,
        badgeTextStyle = badgeTextStyle,
        badgeMaxLines = badgeMaxLines,
        badgeOverflow = badgeOverflow,
        badgeTextAlign = badgeTextAlign,
    )
}