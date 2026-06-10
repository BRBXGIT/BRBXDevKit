package com.brbx.brbxdevkit.calculator.plus_processor

import com.brbx.brbxdevkit.calculator.CalculatorIntent
import com.brbx.brbxdevkit.calculator.CalculatorState
import com.brbx.mvi.processor.BrbxIntentProcessor

interface MinusProcessor : BrbxIntentProcessor<CalculatorState, CalculatorIntent.Minus, Unit>