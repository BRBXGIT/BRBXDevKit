package com.brbx.brbxdevkit.calculator_store.reducers

import com.brbx.brbxdevkit.calculator_store.CalculatorIntent
import com.brbx.brbxdevkit.calculator_store.CalculatorState
import com.brbx.mvi.reducer.BrbxScopedReducer

class PlusReducerBrbx : BrbxScopedReducer<CalculatorState, CalculatorIntent, CalculatorIntent.PlusIntent>(
    targetIntentClass = CalculatorIntent.PlusIntent::class,
) {
    override fun reduceTarget(
        state: CalculatorState,
        intent: CalculatorIntent.PlusIntent
    ): CalculatorState =
        when (intent) {
            CalculatorIntent.PlusIntent.Plus -> {
                state.copy(num = state.num + 1)
            }
        }
}