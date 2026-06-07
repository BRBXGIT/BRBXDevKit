package com.brbx.ui_compose.components.card.appearance

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

@Immutable
interface BRBXCardWidth {

    @JvmInline
    value class Fixed(val value: Dp) : BRBXCardWidth

    data object MaxWidth : BRBXCardWidth
}