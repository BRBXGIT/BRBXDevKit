package com.brbx.brbxdevkit.calculator.minus_processor

import com.brbx.brbxdevkit.calculator.CalculatorIntent
import com.brbx.brbxdevkit.calculator.CalculatorState
import com.brbx.mvi.processor.BrbxIntentProcessor
import com.brbx.mvi.view_model.BrbxMviScope

class MinusProcessorImpl : BrbxIntentProcessor<CalculatorState, CalculatorIntent.Minus, Unit> {

    override fun BrbxMviScope<CalculatorState, Unit>.process(intent: CalculatorIntent.Minus) {
        when (intent) {
            CalculatorIntent.Minus.Remove -> {
                updateState {
                    copy(
                        currentNum = currentNum - 1
                    )
                }
            }
        }
    }
}