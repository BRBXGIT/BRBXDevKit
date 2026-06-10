package com.brbx.mvi.reducer

interface BrbxMviReducer<State, in Intent> {

    fun reduce(state: State, intent: Intent): State
}