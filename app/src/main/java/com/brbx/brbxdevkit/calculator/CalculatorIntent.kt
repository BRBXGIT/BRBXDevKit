package com.brbx.brbxdevkit.calculator

sealed interface CalculatorIntent {
    sealed interface Plus : CalculatorIntent {
        data object Add : Plus
    }

    sealed interface Minus : CalculatorIntent {
        data object Remove : Minus
    }
}