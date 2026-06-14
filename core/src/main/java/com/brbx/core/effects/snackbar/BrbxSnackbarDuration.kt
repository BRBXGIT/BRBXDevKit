package com.brbx.core.effects.snackbar

import androidx.compose.runtime.Immutable

@Immutable
sealed interface BrbxSnackbarDuration {
    data object Short : BrbxSnackbarDuration

    data object Long : BrbxSnackbarDuration

    @JvmInline
    value class Custom(val millis: kotlin.Long) : BrbxSnackbarDuration
}