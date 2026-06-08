package com.brbx.ui_compose.common

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.painter.Painter as ComposePainter

/**
 * A sealed interface representing a flexible icon type for the BRBX design system.
 *
 * [com.brbx.ui_compose.components.image.BRBXIcon] abstracts different ways of providing icon assets to UI components,
 * allowing for seamless usage of resource IDs, [ImageVector]s, [ImageBitmap]s,
 * or custom [ComposePainter]s.
 */
@Immutable
sealed interface BRBXIcon {

    @JvmInline
    value class Res(@param:DrawableRes val resId: Int) : BRBXIcon

    @JvmInline
    value class Vector(val imageVector: ImageVector) : BRBXIcon

    @JvmInline
    value class Bitmap(val bitmap: ImageBitmap) : BRBXIcon

    @JvmInline
    value class Painter(val painter: ComposePainter) : BRBXIcon
}

fun Int.toBRBXIcon(): BRBXIcon = BRBXIcon.Res(resId = this)

fun ImageVector.toBRBXIcon(): BRBXIcon = BRBXIcon.Vector(imageVector = this)

fun ImageBitmap.toBRBXIcon(): BRBXIcon = BRBXIcon.Bitmap(this)

fun ComposePainter.toBRBXIcon(): BRBXIcon = BRBXIcon.Painter(this)