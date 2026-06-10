package com.brbx.brbxdevkit.calculator_store

import androidx.compose.runtime.Immutable

@Immutable
sealed interface CalculatorIntent {

    sealed interface PlusIntent : CalculatorIntent {
        data object Plus : PlusIntent
    }

    sealed interface MinusIntent : CalculatorIntent {
        data object Minus : MinusIntent
    }
}