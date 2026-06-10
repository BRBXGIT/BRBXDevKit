package com.brbx.core.common

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable

@Immutable
interface BrbxText {

    @JvmInline
    value class Res(@param:StringRes val resId: Int) : BrbxText

    @JvmInline
    value class Raw(val text: String) : BrbxText
}

fun @receiver:StringRes Int.toBrbxText(): BrbxText.Res = BrbxText.Res(resId = this)

fun String.toBrbxText(): BrbxText.Raw = BrbxText.Raw(text = this)