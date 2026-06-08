package com.brbx.ui_compose.theme.shapes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class BrbxShapes(
    // Standard circled
    val dp0: Shape = RoundedCornerShape(size = 0.dp),
    val dp4: Shape = RoundedCornerShape(size = 4.dp),
    val dp8: Shape = RoundedCornerShape(size = 8.dp),
    val dp12: Shape = RoundedCornerShape(size = 12.dp),
    val dp16: Shape = RoundedCornerShape(size = 16.dp),
    val dp20: Shape = RoundedCornerShape(size = 20.dp),
    val dp24: Shape = RoundedCornerShape(size = 24.dp),
    val dp28: Shape = RoundedCornerShape(size = 28.dp),
    val dp32: Shape = RoundedCornerShape(size = 32.dp),
    val circle: Shape = RoundedCornerShape(percent = 50),

    // Asymmetry
    val leaf: Shape = RoundedCornerShape(topStartPercent = 50, bottomEndPercent = 50),
    val teardrop: Shape = RoundedCornerShape(
        topStartPercent = 50,
        topEndPercent = 50,
        bottomStartPercent = 50,
        bottomEndPercent = 10
    ),
) {

    // Custom
    fun squircle(smoothness: Double = 3.2): Squircle = Squircle(smoothness = smoothness)
    fun softSpikyCircle(
        numSpikes: Int = 16,
        depthPercentage: Float = 0.08f,
    ): SoftSpikyCircle = SoftSpikyCircle(numSpikes, depthPercentage)
    fun clover(
        petals: Int = 4,
        depthPercentage: Float = 0.25f
    ): Clover = Clover(petals, depthPercentage)
    fun ticket(cutoutRadius: Dp = 12.dp): Ticket = Ticket(cutoutRadius)
}