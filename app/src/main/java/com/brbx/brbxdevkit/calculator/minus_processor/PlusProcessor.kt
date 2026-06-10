package com.brbx.brbxdevkit.calculator.minus_processor

import com.brbx.brbxdevkit.calculator.CalculatorIntent
import com.brbx.brbxdevkit.calculator.CalculatorState
import com.brbx.mvi.processor.BrbxIntentProcessor

interface PlusProcessor : BrbxIntentProcessor<CalculatorState, CalculatorIntent.Plus, Unit>