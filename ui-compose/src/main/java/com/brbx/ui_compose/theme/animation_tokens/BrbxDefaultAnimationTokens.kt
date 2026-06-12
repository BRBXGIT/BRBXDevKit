package com.brbx.ui_compose.theme.animation_tokens

import androidx.compose.runtime.Immutable

@Immutable
internal data class BrbxDefaultAnimationTokens(
    override val zero: Long = 0L,

    override val extraShort1: Long = 50L,
    override val extraShort2: Long = 100L,
    override val extraShort3: Long = 150L,
    override val extraShort4: Long = 200L,

    override val short1: Long = 250L,
    override val short2: Long = 300L,
    override val short3: Long = 350L,
    override val short4: Long = 400L,

    override val medium1: Long = 450L,
    override val medium2: Long = 500L,
    override val medium3: Long = 550L,
    override val medium4: Long = 600L,

    override val long1: Long = 650L,
    override val long2: Long = 700L,
    override val long3: Long = 750L,
    override val long4: Long = 800L,

    override val extraLong1: Long = 850L,
    override val extraLong2: Long = 900L,
    override val extraLong3: Long = 950L,
    override val extraLong4: Long = 1000L,
) : BrbxAnimationTokens