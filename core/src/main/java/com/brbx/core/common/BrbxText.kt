package com.brbx.core.common

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable

/**
 * Represents an abstraction for text content within the Brbx design system.
 *
 * This interface allows UI components to seamlessly accept either localized Android
 * string resources ([Res]) or raw, plain-text strings ([Raw]) through a single parameter,
 * eliminating the need for duplicated component overloads.
 */
@Immutable
interface BrbxText {

    @JvmInline
    value class Res(@param:StringRes val resId: Int) : BrbxText

    @JvmInline
    value class Raw(val text: String) : BrbxText
}

fun @receiver:StringRes Int.toBrbxText(): BrbxText.Res = BrbxText.Res(resId = this)

fun String.toBrbxText(): BrbxText.Raw = BrbxText.Raw(text = this)