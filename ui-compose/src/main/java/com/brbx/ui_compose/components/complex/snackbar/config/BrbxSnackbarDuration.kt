package com.brbx.ui_compose.components.complex.snackbar.config

import androidx.compose.runtime.Immutable

/**
 * Defines the duration for which a [BrbxSnackbar] remains visible on the screen
 * before automatically dismissing.
 *
 * As a sealed interface, it provides a closed set of possible durations,
 * ensuring exhaustive evaluation when configuring the snackbar's lifecycle.
 */
@Immutable
sealed interface BrbxSnackbarDuration {
    data object Short : BrbxSnackbarDuration

    data object Long : BrbxSnackbarDuration

    @JvmInline
    value class Custom(val millis: kotlin.Long) : BrbxSnackbarDuration
}