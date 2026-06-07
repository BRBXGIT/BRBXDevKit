package com.brbx.ui_compose.theme.shapes

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sign
import kotlin.math.sin

@Immutable
class Squircle(
    private val smoothness: Double = 3.2,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path()
        val center = Offset(size.width / 2f, size.height / 2f)
        val rx = size.width / 2f
        val ry = size.height / 2f

        for (angle in 0 until 360 step 2) {
            val radians = Math.toRadians(angle.toDouble())
            val cosT = cos(radians)
            val sinT = sin(radians)

            val x = center.x + (rx * cosT.absoluteValue.pow(2.0 / smoothness) * sign(cosT)).toFloat()
            val y = center.y + (ry * sinT.absoluteValue.pow(2.0 / smoothness) * sign(sinT)).toFloat()

            if (angle == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }
        }
        path.close()
        return Outline.Generic(path)
    }
}

@Immutable
class SoftSpikyCircle(
    private val numSpikes: Int = 16,
    private val depthPercentage: Float = 0.08f,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path()
        val center = Offset(size.width / 2f, size.height / 2f)
        val baseRadius = minOf(size.width, size.height) / 2f
        val depth = baseRadius * depthPercentage

        for (angle in 0 until 360 step 2) {
            val radians = Math.toRadians(angle.toDouble())

            val radius = baseRadius - depth + depth * cos(numSpikes * radians)

            val x = center.x + (radius * cos(radians)).toFloat()
            val y = center.y + (radius * sin(radians)).toFloat()

            if (angle == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }
        }

        path.close()
        return Outline.Generic(path)
    }
}

@Immutable
class Clover(
    private val petals: Int = 4,
    private val depthPercentage: Float = 0.25f
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path()
        val center = Offset(size.width / 2f, size.height / 2f)
        val baseRadius = minOf(size.width, size.height) / 2f
        val depth = baseRadius * depthPercentage

        for (angle in 0 until 360 step 2) {
            val radians = Math.toRadians(angle.toDouble())
            val radius = baseRadius - depth + depth * cos(petals * radians)

            val x = center.x + (radius * cos(radians)).toFloat()
            val y = center.y + (radius * sin(radians)).toFloat()

            if (angle == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }
        }
        path.close()
        return Outline.Generic(path)
    }
}

@Immutable
class Slanted(
    private val slant: Dp = 12.dp
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val slantPx = with(density) { slant.toPx() }
        val path = Path().apply {
            moveTo(slantPx, 0f)
            lineTo(size.width, 0f)
            lineTo(size.width - slantPx, size.height)
            lineTo(0f, size.height)
            close()
        }
        return Outline.Generic(path)
    }
}

@Immutable
class Ticket(
    private val cutoutRadius: Dp = 12.dp
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val radiusPx = with(density) { cutoutRadius.toPx() }
        val path = Path().apply {
            val middleY = size.height / 2f

            moveTo(0f, 0f)
            lineTo(size.width, 0f)
            lineTo(size.width, middleY - radiusPx)

            arcTo(
                rect = Rect(
                    left = size.width - radiusPx,
                    top = middleY - radiusPx,
                    right = size.width + radiusPx,
                    bottom = middleY + radiusPx
                ),
                startAngleDegrees = -90f,
                sweepAngleDegrees = -180f,
                forceMoveTo = false
            )

            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            lineTo(0f, middleY + radiusPx)

            arcTo(
                rect = Rect(
                    left = -radiusPx,
                    top = middleY - radiusPx,
                    right = radiusPx,
                    bottom = middleY + radiusPx
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = -180f,
                forceMoveTo = false
            )
            close()
        }
        return Outline.Generic(path)
    }
}