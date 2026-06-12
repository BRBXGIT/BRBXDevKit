package com.brbx.ui_compose.theme.elevation

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
internal data class BrbxDefaultElevation(
    override val zero: Dp = 0.dp,

    override val small1: Dp = 2.dp,
    override val small2: Dp = 4.dp,
    override val small3: Dp = 6.dp,
    override val small4: Dp = 8.dp,

    override val medium1: Dp = 12.dp,
    override val medium2: Dp = 16.dp,
    override val medium3: Dp = 20.dp,
    override val medium4: Dp = 24.dp,

    override val large1: Dp = 32.dp,
    override val large2: Dp = 38.dp,
    override val large3: Dp = 44.dp,
    override val large4: Dp = 50.dp,
) : BrbxElevation