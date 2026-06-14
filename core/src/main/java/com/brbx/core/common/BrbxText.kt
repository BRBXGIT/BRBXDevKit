package com.brbx.core.common

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.res.stringResource

/**
 * Represents an abstraction for text content within the Brbx design system.
 *
 * This interface allows UI components to seamlessly accept either localized Android
 * string resources ([Res]) or raw, plain-text strings ([Raw]) through a single parameter,
 * eliminating the need for duplicated component overloads.
 */
@Immutable
sealed interface BrbxText {

    @JvmInline
    value class Res(@param:StringRes val resId: Int) : BrbxText

    @JvmInline
    value class Raw(val text: String) : BrbxText
}

fun @receiver:StringRes Int.toBrbxText(): BrbxText.Res = BrbxText.Res(resId = this)

fun String.toBrbxText(): BrbxText.Raw = BrbxText.Raw(text = this)

@Composable
fun BrbxText.asString(): String =
    when (this) {
        is BrbxText.Raw -> this.text
        is BrbxText.Res -> stringResource(id = this.resId)
    }

fun BrbxText.asString(context: android.content.Context): String =
    when (this) {
        is BrbxText.Raw -> this.text
        is BrbxText.Res -> context.getString(this.resId)
    }