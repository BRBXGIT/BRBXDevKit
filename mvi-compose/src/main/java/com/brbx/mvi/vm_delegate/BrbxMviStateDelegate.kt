package com.brbx.mvi.vm_delegate

import kotlinx.coroutines.flow.StateFlow

interface BrbxMviStateDelegate<State> {

    val state: StateFlow<State>
}