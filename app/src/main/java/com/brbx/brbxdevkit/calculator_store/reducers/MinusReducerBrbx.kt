package com.brbx.brbxdevkit.calculator_store.reducers

import com.brbx.brbxdevkit.calculator_store.CalculatorIntent
import com.brbx.brbxdevkit.calculator_store.CalculatorState
import com.brbx.mvi.reducer.BrbxScopedReducer

class MinusReducerBrbx : BrbxScopedReducer<CalculatorState, CalculatorIntent, CalculatorIntent.MinusIntent>(
    targetIntentClass = CalculatorIntent.MinusIntent::class,
) {
    override fun reduceTarget(
        state: CalculatorState,
        intent: CalculatorIntent.MinusIntent
    ): CalculatorState =
        when (intent) {
            CalculatorIntent.MinusIntent.Minus -> {
                state.copy(num = state.num - 1)
            }
        }
}