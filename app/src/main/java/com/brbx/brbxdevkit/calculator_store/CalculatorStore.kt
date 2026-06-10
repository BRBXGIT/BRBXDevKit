package com.brbx.brbxdevkit.calculator_store

import com.brbx.brbxdevkit.calculator_store.reducers.MinusReducer
import com.brbx.brbxdevkit.calculator_store.reducers.PlusReducer
import com.brbx.mvi.store.BrbxMviStore

class CalculatorStore : BrbxMviStore<CalculatorState, CalculatorIntent, Unit>(
    initialState = CalculatorState()
) {
    init {
        register(
            PlusReducer(),
            MinusReducer(),
        )
    }
}