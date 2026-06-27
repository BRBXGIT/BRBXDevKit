package com.brbx.ui_compose.common

import android.content.Context
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
    value class Raw(val text: String) : BrbxText

    class Res(
        @param:StringRes val resId: Int,
        vararg val formatArgs: Any,
    ) : BrbxText {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Res
            if (resId != other.resId) return false
            if (!formatArgs.contentEquals(other.formatArgs)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = resId
            result = 31 * result + formatArgs.contentHashCode()
            return result
        }
    }
}

fun @receiver:StringRes Int.toBrbxText(vararg formatArgs: Any): BrbxText.Res =
    BrbxText.Res(resId = this, *formatArgs)

fun String.toBrbxText(): BrbxText.Raw = BrbxText.Raw(text = this)

@Composable
fun BrbxText.asString(): String =
    when (this) {
        is BrbxText.Raw -> this.text
        is BrbxText.Res -> stringResource(id = this.resId, formatArgs = this.formatArgs)
    }

fun BrbxText.asString(context: Context): String =
    when (this) {
        is BrbxText.Raw -> this.text
        is BrbxText.Res -> context.getString(this.resId, *this.formatArgs)
    }