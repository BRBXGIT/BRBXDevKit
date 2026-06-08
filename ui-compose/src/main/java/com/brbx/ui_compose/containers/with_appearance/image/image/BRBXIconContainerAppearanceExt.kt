package com.brbx.ui_compose.containers.with_appearance.image.image

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mColors

/**
 * Creates a new instance of [com.brbx.ui_compose.containers.with_appearance.image.image.BRBXIconContainerAppearance] with the provided properties.
 * * Use this function to initialize a base appearance configuration. Since this is an
 * inline factory function, it provides a clean way to override default values
 * defined by the application theme.
 */
internal inline fun BRBXIconContainerAppearance(
    // Container
    crossinline containerShape: @Composable () -> Shape = { bShapes.circle },
    crossinline containerBrush: @Composable () -> Brush = { SolidColor(mColors.primary) },
    crossinline contentColor: @Composable () -> Color = { mColors.onPrimary },

    // Layout & Spacing
    crossinline contentAlignment: @Composable () -> Alignment = { remember { Alignment.Center } },
    crossinline contentPadding: @Composable () -> PaddingValues = { PaddingValues(bDimens.dp8) },

    // Badge Container
    crossinline isBadgeVisible: @Composable () -> Boolean = { remember { true } },
    crossinline badgeContentAlignment: @Composable () -> Alignment = { remember { Alignment.Center } },
    crossinline badgeShape: @Composable () -> Shape = { bShapes.softSpikyCircle() },
    crossinline badgeContainerBrush: @Composable () -> Brush = { SolidColor(value = mColors.error) },
    crossinline badgeAlignment: @Composable () -> Alignment = { remember { Alignment.BottomEnd } },
    crossinline badgeContentPadding: @Composable () -> PaddingValues = { PaddingValues(all = bDimens.dp6) },
    crossinline badgeContentColor: @Composable () -> Color = { mColors.onError },
): BRBXIconContainerAppearance = object : BRBXIconContainerAppearance {

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun contentColor(): Color = contentColor()

    // Layout & Spacing
    @Composable override fun contentAlignment(): Alignment = contentAlignment()
    @Composable override fun contentPadding(): PaddingValues = contentPadding()

    // Badge Container
    @Composable override fun isBadgeVisible(): Boolean = isBadgeVisible()
    @Composable override fun badgeContentAlignment(): Alignment = badgeContentAlignment()
    @Composable override fun badgeShape(): Shape = badgeShape()
    @Composable override fun badgeContainerBrush(): Brush = badgeContainerBrush()
    @Composable override fun badgeAlignment(): Alignment = badgeAlignment()
    @Composable override fun badgeContentPadding(): PaddingValues = badgeContentPadding()
    @Composable override fun badgeContentColor(): Color = badgeContentColor()
}

/**
 * Creates a new [BRBXIconContainerAppearance] by copying properties from the current instance.
 * * This function is useful for creating a modified version of an existing appearance
 * object without mutating the original. Note that this creates a new object on
 * every call, so it should be used carefully within recomposition loops.
 * * Better use [rememberCopy] instead
 */
@UnsafeAppearanceCopy
inline fun BRBXIconContainerAppearance.copy(
    // Container
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush = { this.containerBrush() },
    crossinline contentColor: @Composable () -> Color = { this.contentColor() },

    // Layout & Spacing
    crossinline contentAlignment: @Composable () -> Alignment = { this.contentAlignment() },
    crossinline contentPadding: @Composable () -> PaddingValues = { this.contentPadding() },

    // Badge Container
    crossinline isBadgeVisible: @Composable () -> Boolean = { this.isBadgeVisible() },
    crossinline badgeContentAlignment: @Composable () -> Alignment = { this.badgeContentAlignment() },
    crossinline badgeShape: @Composable () -> Shape = { this.badgeShape() },
    crossinline badgeContainerBrush: @Composable () -> Brush = { this.badgeContainerBrush() },
    crossinline badgeAlignment: @Composable () -> Alignment = { this.badgeAlignment() },
    crossinline badgeContentPadding: @Composable () -> PaddingValues = { this.badgeContentPadding() },
    crossinline badgeContentColor: @Composable () -> Color = { this.badgeContentColor() },
): BRBXIconContainerAppearance = object : BRBXIconContainerAppearance {

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun contentColor(): Color = contentColor()

    // Layout & Spacing
    @Composable override fun contentAlignment(): Alignment = contentAlignment()
    @Composable override fun contentPadding(): PaddingValues = contentPadding()

    // Badge Container
    @Composable override fun isBadgeVisible(): Boolean = isBadgeVisible()
    @Composable override fun badgeContentAlignment(): Alignment = badgeContentAlignment()
    @Composable override fun badgeShape(): Shape = badgeShape()
    @Composable override fun badgeContainerBrush(): Brush = badgeContainerBrush()
    @Composable override fun badgeAlignment(): Alignment = badgeAlignment()
    @Composable override fun badgeContentPadding(): PaddingValues = badgeContentPadding()
    @Composable override fun badgeContentColor(): Color = badgeContentColor()
}

/**
 * Creates a memoized copy of the [BRBXIconContainerAppearance] with specified overrides.
 * * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures that
 * a new [BRBXIconContainerAppearance] object is not instantiated on every frame,
 * preventing unnecessary object allocations.
 * 2. **Stability:** It preserves the instance across recompositions as long as
 * the inputs (parameters) remain the same, which helps Jetpack Compose skip
 * unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic runtime
 * changes to the appearance (e.g., changing colors based on interaction states).
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BRBXIconContainerAppearance.rememberCopy(
    // Container
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush = { this.containerBrush() },
    crossinline contentColor: @Composable () -> Color = { this.contentColor() },

    // Layout & Spacing
    crossinline contentAlignment: @Composable () -> Alignment = { this.contentAlignment() },
    crossinline contentPadding: @Composable () -> PaddingValues = { this.contentPadding() },

    // Badge Container
    crossinline isBadgeVisible: @Composable () -> Boolean = { this.isBadgeVisible() },
    crossinline badgeContentAlignment: @Composable () -> Alignment = { this.badgeContentAlignment() },
    crossinline badgeShape: @Composable () -> Shape = { this.badgeShape() },
    crossinline badgeContainerBrush: @Composable () -> Brush = { this.badgeContainerBrush() },
    crossinline badgeAlignment: @Composable () -> Alignment = { this.badgeAlignment() },
    crossinline badgeContentPadding: @Composable () -> PaddingValues = { this.badgeContentPadding() },
    crossinline badgeContentColor: @Composable () -> Color = { this.badgeContentColor() },
): BRBXIconContainerAppearance =
    remember {
        this.copy(
            containerShape = containerShape,
            containerBrush = containerBrush,
            contentColor = contentColor,
            contentAlignment = contentAlignment,
            contentPadding = contentPadding,
            isBadgeVisible = isBadgeVisible,
            badgeContentAlignment = badgeContentAlignment,
            badgeShape = badgeShape,
            badgeContainerBrush = badgeContainerBrush,
            badgeAlignment = badgeAlignment,
            badgeContentPadding = badgeContentPadding,
            badgeContentColor = badgeContentColor,
        )
    }