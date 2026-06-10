package com.brbx.brbxdevkit.calculator_store.reducers

import com.brbx.brbxdevkit.calculator_store.CalculatorIntent
import com.brbx.brbxdevkit.calculator_store.CalculatorState
import com.brbx.mvi.reducer.BrbxMviReducer

class PlusReducer : BrbxMviReducer<CalculatorState, CalculatorIntent.PlusIntent> {

    override fun reduce(
        state: CalculatorState,
        intent: CalculatorIntent.PlusIntent
    ): CalculatorState {
        return when (intent) {
            CalculatorIntent.PlusIntent.Plus -> {
                state.copy(num = state.num + 1)
            }
        }
    }
}