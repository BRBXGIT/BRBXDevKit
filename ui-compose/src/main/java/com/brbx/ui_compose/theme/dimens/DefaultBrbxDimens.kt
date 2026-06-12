package com.brbx.ui_compose.theme.dimens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
internal data class DefaultBrbxDimens(
    override val zero: Dp = 0.dp,

    override val micro1: Dp = 2.dp,
    override val micro2: Dp = 4.dp,
    override val micro3: Dp = 6.dp,
    override val micro4: Dp = 8.dp,
    override val micro5: Dp = 10.dp,
    override val micro6: Dp = 12.dp,
    override val micro7: Dp = 14.dp,
    override val micro8: Dp = 16.dp,

    override val macro1: Dp = 20.dp,
    override val macro2: Dp = 24.dp,
    override val macro3: Dp = 28.dp,
    override val macro4: Dp = 32.dp,
    override val macro5: Dp = 36.dp,
    override val macro6: Dp = 40.dp,
    override val macro7: Dp = 44.dp,
    override val macro8: Dp = 48.dp,
) : BrbxDimens