package com.brbx.brbxdevkit.calculator_store

import com.brbx.brbxdevkit.calculator_store.reducers.MinusReducerBrbx
import com.brbx.brbxdevkit.calculator_store.reducers.PlusReducerBrbx
import com.brbx.mvi.store.BrbxStore

class CalculatorStore : BrbxStore<CalculatorState, CalculatorIntent, Unit>(
    initialState = CalculatorState()
) {
    init {
        register(
            PlusReducerBrbx(),
            MinusReducerBrbx(),
        )
    }
}