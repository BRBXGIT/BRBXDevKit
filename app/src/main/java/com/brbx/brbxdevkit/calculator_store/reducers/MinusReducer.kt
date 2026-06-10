package com.brbx.brbxdevkit.calculator_store.reducers

import com.brbx.brbxdevkit.calculator_store.CalculatorIntent
import com.brbx.brbxdevkit.calculator_store.CalculatorState
import com.brbx.mvi.reducer.BrbxMviReducer

class MinusReducer : BrbxMviReducer<CalculatorState, CalculatorIntent.MinusIntent> {


    override fun reduce(
        state: CalculatorState,
        intent: CalculatorIntent.MinusIntent,
    ): CalculatorState {
        return when (intent) {
            CalculatorIntent.MinusIntent.Minus -> {
                state.copy(num = state.num - 1)
            }
        }
    }
}