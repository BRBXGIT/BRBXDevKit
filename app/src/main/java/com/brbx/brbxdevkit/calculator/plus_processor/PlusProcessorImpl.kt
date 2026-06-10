package com.brbx.brbxdevkit.calculator.plus_processor

import com.brbx.brbxdevkit.calculator.CalculatorIntent
import com.brbx.brbxdevkit.calculator.CalculatorState
import com.brbx.brbxdevkit.calculator.minus_processor.PlusProcessor
import com.brbx.mvi.view_model.BrbxMviScope

class PlusProcessorImpl : PlusProcessor {
    
    override fun BrbxMviScope<CalculatorState, Unit>.process(intent: CalculatorIntent.Plus) {
        when (intent) {
            CalculatorIntent.Plus.Add -> {
                updateState {
                    it.copy(
                        currentNum = it.currentNum + 1
                    )
                }
            }
        }
    }
}