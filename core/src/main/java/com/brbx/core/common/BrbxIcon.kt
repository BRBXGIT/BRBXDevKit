package com.brbx.core.common

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
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

fun @receiver:DrawableRes Int.toBrbxIcon(): BrbxIcon.Res = BrbxIcon.Res(resId = this)

fun ImageVector.toBrbxIcon(): BrbxIcon.Vector = BrbxIcon.Vector(imageVector = this)

fun ImageBitmap.toBrbxIcon(): BrbxIcon.Bitmap = BrbxIcon.Bitmap(this)

fun ComposePainter.toBrbxIcon(): BrbxIcon.Painter = BrbxIcon.Painter(this)

@Composable
fun BrbxIcon.asPainter(): ComposePainter =
    when (this) {
        is BrbxIcon.Res -> painterResource(id = this.resId)
        is BrbxIcon.Vector -> rememberVectorPainter(image = this.imageVector)
        is BrbxIcon.Bitmap -> remember(key1 = this.bitmap) { BitmapPainter(image = this.bitmap) }
        is BrbxIcon.Painter -> this.painter
    }