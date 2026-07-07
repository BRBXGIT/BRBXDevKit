package com.brbx.ui_compose.components.complex.content_card.content_card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
 * [com.brbx.ui_compose.components.complex.content_card.content_card.BrbxContentCardAppearance]
 * with the provided properties.
 *
 * Use this function to initialize a base appearance configuration. Since
 * this is an inline factory function, it provides a clean way to override
 * default values defined by the application theme.
 */
internal inline fun BrbxContentCardAppearance(
    // Container & Interaction
    crossinline containerBorder: @Composable () -> BorderStroke =
        { remember { BorderStroke(width = 0.dp, brush = SolidColor(value = Color.Transparent)) } },
    crossinline containerShape: @Composable () -> Shape =
        { bShapes.micro3 },
    crossinline containerBackground: @Composable () -> Brush =
        { SolidColor(value = mColors.surfaceContainerHigh) },
    crossinline containerRippleColor: @Composable () -> Color =
        { mColors.surface },
    crossinline hapticFeedbackEnabled: @Composable () -> Boolean =
        { remember { true } },
    crossinline containerElevation: @Composable () -> Dp =
        { bElevation.zero },
    crossinline containerElevationAmbientColor: @Composable () -> Color =
        { remember { Color.Transparent } },
    crossinline containerElevationSpotColor: @Composable () -> Color =
        { remember { Color.Transparent } },

    // Info Layout & Background
    crossinline infoAlignment: @Composable () -> Alignment =
        { remember { Alignment.BottomStart } },
    crossinline infoSpacedBy: @Composable () -> Dp =
        { bDimens.micro2 },
    crossinline infoBackground: @Composable () -> Brush =
        { SolidColor(value = mColors.tertiary) },
    crossinline infoContentPadding: @Composable () -> PaddingValues =
        { PaddingValues(all = bDimens.micro4) },

    // Title & Description
    crossinline titleColor: @Composable () -> Color =
        { mColors.onTertiary },
    crossinline descriptionColor: @Composable () -> Color =
        { mColors.onTertiary.copy(alpha = 0.8f) },

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
): BrbxContentCardAppearance = object : BrbxContentCardAppearance {

    // Container & Interaction
    @Composable override fun containerBorder(): BorderStroke =
        containerBorder()
    @Composable override fun containerShape(): Shape =
        containerShape()
    @Composable override fun containerBackground(): Brush =
        containerBackground()
    @Composable override fun containerRippleColor(): Color =
        containerRippleColor()
    @Composable override fun hapticFeedbackEnabled(): Boolean =
        hapticFeedbackEnabled()
    @Composable override fun containerElevation(): Dp =
        containerElevation()
    @Composable override fun containerElevationAmbientColor(): Color =
        containerElevationAmbientColor()
    @Composable override fun containerElevationSpotColor(): Color =
        containerElevationSpotColor()

    // Info Layout & Background
    @Composable override fun infoAlignment(): Alignment = infoAlignment()
    @Composable override fun infoSpacedBy(): Dp = infoSpacedBy()
    @Composable override fun infoBackground(): Brush = infoBackground()
    @Composable override fun infoContentPadding(): PaddingValues = infoContentPadding()

    // Title & Description
    @Composable override fun titleColor(): Color = titleColor()
    @Composable override fun descriptionColor(): Color = descriptionColor()

    // Default Typography
    @Composable override fun defaultTitleStyle(): TextStyle = defaultTitleStyle()
    @Composable override fun defaultTitleMaxLines(): Int = defaultTitleMaxLines()
    @Composable override fun defaultTitleOverflow(): TextOverflow = defaultTitleOverflow()
    @Composable override fun defaultDescriptionStyle(): TextStyle = defaultDescriptionStyle()
    @Composable override fun defaultDescriptionMaxLines(): Int = defaultDescriptionMaxLines()
    @Composable override fun defaultDescriptionOverflow(): TextOverflow = defaultDescriptionOverflow()
}

/**
 * Creates a new [BrbxContentCardAppearance] by copying properties from the
 * current instance.
 *
 * This function is useful for creating a modified version of an existing
 * appearance object without mutating the original. Note that this creates
 * a new object on every call, so it should be used carefully within
 * recomposition loops.
 *
 * Better use [rememberCopy] instead.
 */
@UnsafeAppearanceCopy
inline fun BrbxContentCardAppearance.copy(
    // Container & Interaction
    crossinline containerBorder: @Composable () -> BorderStroke =
        { this.containerBorder() },
    crossinline containerShape: @Composable () -> Shape =
        { this.containerShape() },
    crossinline containerBackground: @Composable () -> Brush =
        { this.containerBackground() },
    crossinline containerRippleColor: @Composable () -> Color =
        { this.containerRippleColor() },
    crossinline hapticFeedbackEnabled: @Composable () -> Boolean =
        { this.hapticFeedbackEnabled() },
    crossinline containerElevation: @Composable () -> Dp =
        { this.containerElevation() },
    crossinline containerElevationAmbientColor: @Composable () -> Color =
        { this.containerElevationAmbientColor() },
    crossinline containerElevationSpotColor: @Composable () -> Color =
        { this.containerElevationSpotColor() },

    // Info Layout & Background
    crossinline infoAlignment: @Composable () -> Alignment = { this.infoAlignment() },
    crossinline infoSpacedBy: @Composable () -> Dp = { this.infoSpacedBy() },
    crossinline infoBackground: @Composable () -> Brush = { this.infoBackground() },
    crossinline infoContentPadding: @Composable () -> PaddingValues = { this.infoContentPadding() },

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
): BrbxContentCardAppearance = object : BrbxContentCardAppearance {

    // Container & Interaction
    @Composable override fun containerBorder(): BorderStroke =
        containerBorder()
    @Composable override fun containerShape(): Shape =
        containerShape()
    @Composable override fun containerBackground(): Brush =
        containerBackground()
    @Composable override fun containerRippleColor(): Color =
        containerRippleColor()
    @Composable override fun hapticFeedbackEnabled(): Boolean =
        hapticFeedbackEnabled()
    @Composable override fun containerElevation(): Dp =
        containerElevation()
    @Composable override fun containerElevationAmbientColor(): Color =
        containerElevationAmbientColor()
    @Composable override fun containerElevationSpotColor(): Color =
        containerElevationSpotColor()

    // Info Layout & Background
    @Composable override fun infoAlignment(): Alignment = infoAlignment()
    @Composable override fun infoSpacedBy(): Dp = infoSpacedBy()
    @Composable override fun infoBackground(): Brush = infoBackground()
    @Composable override fun infoContentPadding(): PaddingValues = infoContentPadding()

    // Title & Description
    @Composable override fun titleColor(): Color = titleColor()
    @Composable override fun descriptionColor(): Color = descriptionColor()

    // Default Typography
    @Composable override fun defaultTitleStyle(): TextStyle = defaultTitleStyle()
    @Composable override fun defaultTitleMaxLines(): Int = defaultTitleMaxLines()
    @Composable override fun defaultTitleOverflow(): TextOverflow = defaultTitleOverflow()
    @Composable override fun defaultDescriptionStyle(): TextStyle = defaultDescriptionStyle()
    @Composable override fun defaultDescriptionMaxLines(): Int = defaultDescriptionMaxLines()
    @Composable override fun defaultDescriptionOverflow(): TextOverflow = defaultDescriptionOverflow()
}

/**
 * Creates a memoized copy of the [BrbxContentCardAppearance] with specified
 * overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures
 * that a new [BrbxContentCardAppearance] object is not instantiated on every
 * frame, preventing unnecessary object allocations.
 * 2. **Stability:** It preserves the instance across recompositions as long as
 * the inputs (parameters) remain the same, which helps Jetpack Compose skip
 * unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic runtime
 * changes to the appearance (e.g., changing colors based on interaction
 * states).
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BrbxContentCardAppearance.rememberCopy(
    // Container & Interaction
    crossinline containerBorder: @Composable () -> BorderStroke =
        { this.containerBorder() },
    crossinline containerShape: @Composable () -> Shape =
        { this.containerShape() },
    crossinline containerBackground: @Composable () -> Brush =
        { this.containerBackground() },
    crossinline containerRippleColor: @Composable () -> Color =
        { this.containerRippleColor() },
    crossinline hapticFeedbackEnabled: @Composable () -> Boolean =
        { this.hapticFeedbackEnabled() },
    crossinline containerElevation: @Composable () -> Dp =
        { this.containerElevation() },
    crossinline containerElevationAmbientColor: @Composable () -> Color =
        { this.containerElevationAmbientColor() },
    crossinline containerElevationSpotColor: @Composable () -> Color =
        { this.containerElevationSpotColor() },

    // Info Layout & Background
    crossinline infoAlignment: @Composable () -> Alignment =
        { this.infoAlignment() },
    crossinline infoSpacedBy: @Composable () -> Dp =
        { this.infoSpacedBy() },
    crossinline infoBackground: @Composable () -> Brush =
        { this.infoBackground() },
    crossinline infoContentPadding: @Composable () -> PaddingValues =
        { this.infoContentPadding() },

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
): BrbxContentCardAppearance =
    remember {
        this.copy(
            containerBorder = containerBorder,
            containerShape = containerShape,
            containerBackground = containerBackground,
            containerRippleColor = containerRippleColor,
            hapticFeedbackEnabled = hapticFeedbackEnabled,
            containerElevation = containerElevation,
            containerElevationAmbientColor = containerElevationAmbientColor,
            containerElevationSpotColor = containerElevationSpotColor,
            infoAlignment = infoAlignment,
            infoSpacedBy = infoSpacedBy,
            infoBackground = infoBackground,
            infoContentPadding = infoContentPadding,
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