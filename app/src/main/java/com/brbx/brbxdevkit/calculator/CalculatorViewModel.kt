package com.brbx.brbxdevkit.calculator

import com.brbx.brbxdevkit.calculator.minus_processor.PlusProcessor
import com.brbx.brbxdevkit.calculator.plus_processor.MinusProcessor
import com.brbx.mvi.view_model.BrbxMviViewModel

class CalculatorViewModel(
    private val plusProcessor: PlusProcessor,
    private val minusProcessor: MinusProcessor,
) : BrbxMviViewModel<CalculatorState, CalculatorIntent, Unit>(
    initialState = CalculatorState(),
) {
    override fun onIntent(intent: CalculatorIntent) {
        when (intent) {
            is CalculatorIntent.Minus -> with(minusProcessor) {
                mviScope.process(intent)
            }
            is CalculatorIntent.Plus -> with(plusProcessor) {
                mviScope.process(intent)
            }
        }
    }
}