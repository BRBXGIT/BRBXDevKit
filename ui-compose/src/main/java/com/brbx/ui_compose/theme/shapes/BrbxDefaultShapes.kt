package com.brbx.ui_compose.theme.shapes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
internal data class BrbxDefaultShapes(
    override val zero: Shape = RoundedCornerShape(size = 0.dp),

    override val micro1: Shape = RoundedCornerShape(size = 4.dp),
    override val micro2: Shape = RoundedCornerShape(size = 8.dp),
    override val micro3: Shape = RoundedCornerShape(size = 12.dp),
    override val micro4: Shape = RoundedCornerShape(size = 16.dp),

    override val macro1: Shape = RoundedCornerShape(size = 20.dp),
    override val macro2: Shape = RoundedCornerShape(size = 24.dp),
    override val macro3: Shape = RoundedCornerShape(size = 28.dp),
    override val macro4: Shape = RoundedCornerShape(size = 32.dp),

    override val circle: Shape = RoundedCornerShape(percent = 50),
    override val leaf: Shape = RoundedCornerShape(topStartPercent = 50, bottomEndPercent = 50),
    override val teardrop: Shape = RoundedCornerShape(
        topStartPercent = 50,
        topEndPercent = 50,
        bottomStartPercent = 50,
        bottomEndPercent = 10
    ),
) : BrbxShapes {
    override fun squircle(smoothness: Double): Shape =
        Squircle(smoothness = smoothness)

    override fun softSpikyCircle(numSpikes: Int, depthPercentage: Float): Shape =
        SoftSpikyCircle(numSpikes, depthPercentage)

    override fun clover(petals: Int, depthPercentage: Float): Shape =
        Clover(petals, depthPercentage)

    override fun ticket(cutoutRadius: Dp): Shape =
        Ticket(cutoutRadius)
}