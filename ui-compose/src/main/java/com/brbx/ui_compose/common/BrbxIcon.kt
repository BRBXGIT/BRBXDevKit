package com.brbx.ui_compose.common

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.painter.Painter as ComposePainter

/**
 * A versatile, immutable wrapper that encapsulates different types of image sources.
 *
 * By using this sealed interface, UI components can accept a single `BrbxIcon` parameter
 * instead of requiring multiple overloads for resources, vectors, bitmaps, or painters.
 * Its sealed nature ensures exhaustive handling in `when` statements during UI rendering.
 */
@Immutable
sealed interface BrbxIcon {

    @JvmInline
    value class Res(@param:DrawableRes val resId: Int) : BrbxIcon

    @JvmInline
    value class Vector(val imageVector: ImageVector) : BrbxIcon

    @JvmInline
    value class Bitmap(val bitmap: ImageBitmap) : BrbxIcon

    @JvmInline
    value class Painter(val painter: ComposePainter) : BrbxIcon
}

fun Int.toBrbxIcon(): BrbxIcon = BrbxIcon.Res(resId = this)

fun ImageVector.toBrbxIcon(): BrbxIcon = BrbxIcon.Vector(imageVector = this)

fun ImageBitmap.toBrbxIcon(): BrbxIcon = BrbxIcon.Bitmap(this)

fun ComposePainter.toBrbxIcon(): BrbxIcon = BrbxIcon.Painter(this)