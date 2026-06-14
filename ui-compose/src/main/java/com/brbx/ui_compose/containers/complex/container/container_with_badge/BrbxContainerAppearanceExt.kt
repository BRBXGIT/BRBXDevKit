package com.brbx.ui_compose.containers.complex.container.container_with_badge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mColors

/**
 * Creates a new instance of
 * [com.brbx.ui_compose.containers.complex.container.container_with_badge.BrbxContainerWithBadgeAppearance]
 * with the provided properties.
 *
 * Use this function to initialize a base appearance configuration. Since
 * this is an inline factory function, it provides a clean way to override
 * default values defined by the application theme.
 */
internal inline fun BrbxContainerWithBadgeAppearance(
    // Container
    crossinline containerShape: @Composable () -> Shape =
        { bShapes.circle },
    crossinline containerBrush: @Composable () -> Brush =
        { SolidColor(mColors.primary) },

    // Icon
    crossinline contentColor: @Composable () -> Color =
        { mColors.onPrimary },

    // Layout & Spacing
    crossinline contentAlignment: @Composable () -> Alignment =
        { remember { Alignment.Center } },

    // Badge Container
    crossinline badgeContentAlignment: @Composable () -> Alignment =
        { remember { Alignment.Center } },
    crossinline badgeShape: @Composable () -> Shape =
        { bShapes.softSpikyCircle() },
    crossinline badgeContainerBrush: @Composable () -> Brush =
        { SolidColor(value = mColors.error) },
    crossinline badgeAlignment: @Composable () -> Alignment =
        { remember { Alignment.BottomEnd } },
    crossinline badgePositionYDivider: @Composable () -> Int =
        { remember { 4 } },
    crossinline badgePositionXDivider: @Composable () -> Int =
        { remember { 4 } },
    crossinline badgeContentColor: @Composable () -> Color =
        { mColors.onError },
): BrbxContainerWithBadgeAppearance = object : BrbxContainerWithBadgeAppearance {

    // Container
    @Composable
    override fun containerShape(): Shape = containerShape()

    @Composable
    override fun containerBrush(): Brush = containerBrush()

    // Content
    @Composable
    override fun contentColor(): Color = contentColor()

    // Layout & Spacing
    @Composable
    override fun contentAlignment(): Alignment = contentAlignment()

    // Badge Container
    @Composable
    override fun badgeContentAlignment(): Alignment = badgeContentAlignment()

    @Composable
    override fun badgeShape(): Shape = badgeShape()

    @Composable
    override fun badgeContainerBrush(): Brush = badgeContainerBrush()

    @Composable
    override fun badgeAlignment(): Alignment = badgeAlignment()

    @Composable
    override fun badgePositionYDivider(): Int = badgePositionYDivider()

    @Composable
    override fun badgePositionXDivider(): Int = badgePositionXDivider()

    @Composable
    override fun badgeContentColor(): Color = badgeContentColor()
}

/**
 * Creates a new [BrbxContainerWithBadgeAppearance] by copying properties from
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
inline fun BrbxContainerWithBadgeAppearance.copy(
    // Container
    crossinline containerShape: @Composable () -> Shape =
        { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush =
        { this.containerBrush() },

    // Content
    crossinline contentColor: @Composable () -> Color =
        { this.contentColor() },

    // Layout & Spacing
    crossinline contentAlignment: @Composable () -> Alignment =
        { this.contentAlignment() },

    // Badge Container
    crossinline badgeContentAlignment: @Composable () -> Alignment =
        { this.badgeContentAlignment() },
    crossinline badgeShape: @Composable () -> Shape =
        { this.badgeShape() },
    crossinline badgeContainerBrush: @Composable () -> Brush =
        { this.badgeContainerBrush() },
    crossinline badgeAlignment: @Composable () -> Alignment =
        { this.badgeAlignment() },
    crossinline badgePositionYDivider: @Composable () -> Int =
        { this.badgePositionYDivider() },
    crossinline badgePositionXDivider: @Composable () -> Int =
        { this.badgePositionXDivider() },
    crossinline badgeContentColor: @Composable () -> Color =
        { this.badgeContentColor() },
): BrbxContainerWithBadgeAppearance = object : BrbxContainerWithBadgeAppearance {

    // Container
    @Composable
    override fun containerShape(): Shape = containerShape()

    @Composable
    override fun containerBrush(): Brush = containerBrush()

    // Content
    @Composable
    override fun contentColor(): Color = contentColor()

    // Layout & Spacing
    @Composable
    override fun contentAlignment(): Alignment = contentAlignment()

    // Badge Container
    @Composable
    override fun badgeContentAlignment(): Alignment = badgeContentAlignment()

    @Composable
    override fun badgeShape(): Shape = badgeShape()

    @Composable
    override fun badgeContainerBrush(): Brush = badgeContainerBrush()

    @Composable
    override fun badgeAlignment(): Alignment = badgeAlignment()

    @Composable
    override fun badgePositionYDivider(): Int = badgePositionYDivider()

    @Composable
    override fun badgePositionXDivider(): Int = badgePositionXDivider()

    @Composable
    override fun badgeContentColor(): Color = badgeContentColor()
}

/**
 * Creates a memoized copy of the [BrbxContainerWithBadgeAppearance] with
 * specified overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember]
 * ensures that a new [BrbxContainerWithBadgeAppearance] object is not
 * instantiated on every frame, preventing unnecessary object
 * allocations.
 * 2. **Stability:** It preserves the instance across recompositions
 * as long as the inputs (parameters) remain the same, which helps
 * Jetpack Compose skip unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic
 * runtime changes to the appearance (e.g., changing colors based
 * on interaction states).
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BrbxContainerWithBadgeAppearance.rememberCopy(
    // Container
    crossinline containerShape: @Composable () -> Shape =
        { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush =
        { this.containerBrush() },

    // Content
    crossinline contentColor: @Composable () -> Color =
        { this.contentColor() },

    // Layout & Spacing
    crossinline contentAlignment: @Composable () -> Alignment =
        { this.contentAlignment() },

    // Badge Container
    crossinline badgeContentAlignment: @Composable () -> Alignment =
        { this.badgeContentAlignment() },
    crossinline badgeShape: @Composable () -> Shape =
        { this.badgeShape() },
    crossinline badgeContainerBrush: @Composable () -> Brush =
        { this.badgeContainerBrush() },
    crossinline badgeAlignment: @Composable () -> Alignment =
        { this.badgeAlignment() },
    crossinline badgePositionYDivider: @Composable () -> Int =
        { this.badgePositionYDivider() },
    crossinline badgePositionXDivider: @Composable () -> Int =
        { this.badgePositionXDivider() },
    crossinline badgeContentColor: @Composable () -> Color =
        { this.badgeContentColor() },
): BrbxContainerWithBadgeAppearance =
    remember {
        this.copy(
            containerShape = containerShape,
            containerBrush = containerBrush,
            contentColor = contentColor,
            contentAlignment = contentAlignment,
            badgeContentAlignment = badgeContentAlignment,
            badgeShape = badgeShape,
            badgeContainerBrush = badgeContainerBrush,
            badgeAlignment = badgeAlignment,
            badgePositionYDivider = badgePositionYDivider,
            badgePositionXDivider = badgePositionXDivider,
            badgeContentColor = badgeContentColor,
        )
    }