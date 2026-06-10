package com.brbx.mvi.reducer

interface BrbxReducer<State, Intent : Any> {

    fun reduce(state: State, intent: Intent): State
}