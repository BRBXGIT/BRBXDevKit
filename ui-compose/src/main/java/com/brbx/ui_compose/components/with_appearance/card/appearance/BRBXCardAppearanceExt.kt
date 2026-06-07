package com.brbx.ui_compose.components.with_appearance.card.appearance

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
import com.brbx.ui_compose.components.with_appearance.annotations.UnsafeAppearanceCopy
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mColors
import com.brbx.ui_compose.theme.mTypography

/**
 * Creates a new instance of [BRBXContentCardAppearance] with the provided properties.
 * * Use this function to initialize a base appearance configuration. Since this is an
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
    crossinline badgeContainerPadding: @Composable () -> PaddingValues = { PaddingValues(bDimens.dp8) },
    crossinline badgeContainerShape: @Composable () -> Shape = { bShapes.softSpikyCircle() },
    crossinline badgePadding: @Composable () -> PaddingValues = { PaddingValues(bDimens.dp8) },

    // Info Layout & Background
    crossinline infoAlignment: @Composable () -> Alignment = { remember { Alignment.BottomStart } },
    crossinline infoSpacedBy: @Composable () -> Dp = { bDimens.dp4 },
    crossinline infoBackground: @Composable () -> Brush = { SolidColor(mColors.tertiaryContainer) },
    crossinline infoPadding: @Composable () -> PaddingValues = { PaddingValues(bDimens.dp8) },

    // Typography
    crossinline titleAppearance: @Composable () -> TextStyle = {
        mTypography.bodyMedium.copy(
            color = mColors.onTertiaryContainer,
            fontWeight = FontWeight.W600,
        )
    },
    crossinline titleMaxLines: @Composable () -> Int = { remember { 1 } },
    crossinline titleOverflow: @Composable () -> TextOverflow = { remember { TextOverflow.Ellipsis } },
    crossinline descriptionAppearance: @Composable () -> TextStyle = {
        mTypography.labelMedium.copy(color = mColors.secondary)
    },
    crossinline descriptionOverflow: @Composable () -> TextOverflow = { remember { TextOverflow.Ellipsis } },
    crossinline descriptionMaxLines: @Composable () -> Int = { remember { 1 } },
    crossinline badgeTextAppearance: @Composable () -> TextStyle = {
        mTypography.labelSmall.copy(color = mColors.onPrimary)
    },
    crossinline badgeMaxLines: @Composable () -> Int = { remember { 1 } },
    crossinline badgeOverflow: @Composable () -> TextOverflow = { remember { TextOverflow.Clip } },
    crossinline badgeTextAlign: @Composable () -> TextAlign = { remember { TextAlign.Center } },
): BRBXContentCardAppearance = object : BRBXContentCardAppearance {

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
    @Composable override fun titleAppearance(): TextStyle = titleAppearance()
    @Composable override fun titleMaxLines(): Int = titleMaxLines()
    @Composable override fun titleOverflow(): TextOverflow = titleOverflow()
    @Composable override fun descriptionAppearance(): TextStyle = descriptionAppearance()
    @Composable override fun descriptionOverflow(): TextOverflow = descriptionOverflow()
    @Composable override fun descriptionMaxLines(): Int = descriptionMaxLines()
    @Composable override fun badgeTextAppearance(): TextStyle = badgeTextAppearance()
    @Composable override fun badgeMaxLines(): Int = badgeMaxLines()
    @Composable override fun badgeOverflow(): TextOverflow = badgeOverflow()
    @Composable override fun badgeTextAlign(): TextAlign = badgeTextAlign()
}

/**
 * Creates a new [BRBXContentCardAppearance] by copying properties from the current instance.
 * * This function is useful for creating a modified version of an existing appearance
 * object without mutating the original. Note that this creates a new object on
 * every call, so it should be used carefully within recomposition loops.
 * * Better use [rememberCopy] instead
 */
@UnsafeAppearanceCopy
inline fun BRBXContentCardAppearance.copy(
    // Container & Interaction
    crossinline width: @Composable () -> Dp = { this.containerWidth() },
    crossinline height: @Composable () -> Dp = { this.containerHeight() },
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBackground: @Composable () -> Brush = { this.containerBackground() },
    crossinline containerRippleColor: @Composable () -> Color = { this.containerRippleColor() },

    // Badge Layout & Background
    crossinline badgeAlignment: @Composable () -> Alignment = { this.badgeAlignment() },
    crossinline badgeContainerBrush: @Composable () -> Brush = { this.badgeContainerBrush() },
    crossinline badgeContainerPadding: @Composable () -> PaddingValues = { this.badgeContainerPadding() },
    crossinline badgeContainerShape: @Composable () -> Shape = { this.badgeContainerShape() },
    crossinline badgePadding: @Composable () -> PaddingValues = { this.badgePadding() },

    // Info Layout & Background
    crossinline infoAlignment: @Composable () -> Alignment = { this.infoAlignment() },
    crossinline footerSpacedBy: @Composable () -> Dp = { this.infoSpacedBy() },
    crossinline footerBackground: @Composable () -> Brush = { this.infoBackground() },
    crossinline footerPadding: @Composable () -> PaddingValues = { this.infoPadding() },

    // Typography
    crossinline titleAppearance: @Composable () -> TextStyle = { this.titleAppearance() },
    crossinline titleMaxLines: @Composable () -> Int = { this.titleMaxLines() },
    crossinline titleOverflow: @Composable () -> TextOverflow = { this.titleOverflow() },
    crossinline descriptionAppearance: @Composable () -> TextStyle = { this.descriptionAppearance() },
    crossinline descriptionOverflow: @Composable () -> TextOverflow = { this.descriptionOverflow() },
    crossinline descriptionMaxLines: @Composable () -> Int = { this.descriptionMaxLines() },
    crossinline badgeTextAppearance: @Composable () -> TextStyle = { this.badgeTextAppearance() },
    crossinline badgeMaxLines: @Composable () -> Int = { this.badgeMaxLines() },
    crossinline badgeOverflow: @Composable () -> TextOverflow = { this.badgeOverflow() },
    crossinline badgeTextAlign: @Composable () -> TextAlign = { this.badgeTextAlign() },
): BRBXContentCardAppearance = object : BRBXContentCardAppearance {

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
    @Composable override fun titleAppearance(): TextStyle = titleAppearance()
    @Composable override fun titleMaxLines(): Int = titleMaxLines()
    @Composable override fun titleOverflow(): TextOverflow = titleOverflow()
    @Composable override fun descriptionAppearance(): TextStyle = descriptionAppearance()
    @Composable override fun descriptionOverflow(): TextOverflow = descriptionOverflow()
    @Composable override fun descriptionMaxLines(): Int = descriptionMaxLines()
    @Composable override fun badgeTextAppearance(): TextStyle = badgeTextAppearance()
    @Composable override fun badgeMaxLines(): Int = badgeMaxLines()
    @Composable override fun badgeOverflow(): TextOverflow = badgeOverflow()
    @Composable override fun badgeTextAlign(): TextAlign = badgeTextAlign()
}

/**
 * Creates a memoized copy of the [BRBXContentCardAppearance] with specified overrides.
 * * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures that
 * a new [BRBXContentCardAppearance] object is not instantiated on every frame,
 * preventing unnecessary object allocations.
 * 2. **Stability:** It preserves the instance across recompositions as long as
 * the inputs (parameters) remain the same, which helps Jetpack Compose skip
 * unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic runtime
 * changes to the appearance (e.g., changing colors based on interaction states).
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BRBXContentCardAppearance.rememberCopy(
    // Container & Interaction
    crossinline width: @Composable () -> Dp = { this.containerWidth() },
    crossinline height: @Composable () -> Dp = { this.containerHeight() },
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBackground: @Composable () -> Brush = { this.containerBackground() },
    crossinline containerRippleColor: @Composable () -> Color = { this.containerRippleColor() },

    // Badge Layout & Background
    crossinline badgeAlignment: @Composable () -> Alignment = { this.badgeAlignment() },
    crossinline badgeContainerBrush: @Composable () -> Brush = { this.badgeContainerBrush() },
    crossinline badgeContainerPadding: @Composable () -> PaddingValues = { this.badgeContainerPadding() },
    crossinline badgeContainerShape: @Composable () -> Shape = { this.badgeContainerShape() },
    crossinline badgePadding: @Composable () -> PaddingValues = { this.badgePadding() },

    // Info Layout & Background
    crossinline infoAlignment: @Composable () -> Alignment = { this.infoAlignment() },
    crossinline footerSpacedBy: @Composable () -> Dp = { this.infoSpacedBy() },
    crossinline footerBackground: @Composable () -> Brush = { this.infoBackground() },
    crossinline footerPadding: @Composable () -> PaddingValues = { this.infoPadding() },

    // Typography
    crossinline titleAppearance: @Composable () -> TextStyle = { this.titleAppearance() },
    crossinline titleMaxLines: @Composable () -> Int = { this.titleMaxLines() },
    crossinline titleOverflow: @Composable () -> TextOverflow = { this.titleOverflow() },
    crossinline descriptionAppearance: @Composable () -> TextStyle = { this.descriptionAppearance() },
    crossinline descriptionOverflow: @Composable () -> TextOverflow = { this.descriptionOverflow() },
    crossinline descriptionMaxLines: @Composable () -> Int = { this.descriptionMaxLines() },
    crossinline badgeTextAppearance: @Composable () -> TextStyle = { this.badgeTextAppearance() },
    crossinline badgeMaxLines: @Composable () -> Int = { this.badgeMaxLines() },
    crossinline badgeOverflow: @Composable () -> TextOverflow = { this.badgeOverflow() },
    crossinline badgeTextAlign: @Composable () -> TextAlign = { this.badgeTextAlign() },
): BRBXContentCardAppearance =
    remember {
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
            titleAppearance = titleAppearance,
            titleMaxLines = titleMaxLines,
            titleOverflow = titleOverflow,
            descriptionAppearance = descriptionAppearance,
            descriptionOverflow = descriptionOverflow,
            descriptionMaxLines = descriptionMaxLines,
            badgeTextAppearance = badgeTextAppearance,
            badgeMaxLines = badgeMaxLines,
            badgeOverflow = badgeOverflow,
            badgeTextAlign = badgeTextAlign,
        )
    }