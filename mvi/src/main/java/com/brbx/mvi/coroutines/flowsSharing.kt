package com.brbx.mvi.coroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn

context(viewModel: ViewModel)
fun <T> Flow<T>.stateInEagerly(initialValue: T): StateFlow<T> =
    this.stateIn(
        scope = viewModel.viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = initialValue,
    )

context(viewModel: ViewModel)
fun <T> Flow<T>.stateInLazily(initialValue: T): StateFlow<T> =
    this.stateIn(
        scope = viewModel.viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = initialValue,
    )

context(viewModel: ViewModel)
fun <T> Flow<T>.stateInWhileSubscribed(
    initialValue: T,
    stopTimeoutMillis: Long = 1L,
): StateFlow<T> =
    this.stateIn(
        scope = viewModel.viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = stopTimeoutMillis),
        initialValue = initialValue,
    )

context(viewModel: ViewModel)
fun <T> Flow<T>.shareInEagerly(): SharedFlow<T> =
    this.shareIn(
        scope = viewModel.viewModelScope,
        started = SharingStarted.Eagerly,
    )

context(viewModel: ViewModel)
fun <T> Flow<T>.shareInLazily(): SharedFlow<T> =
    this.shareIn(
        scope = viewModel.viewModelScope,
        started = SharingStarted.Lazily,
    )

context(viewModel: ViewModel)
fun <T> Flow<T>.shareInWhileSubscribed(stopTimeoutMillis: Long = 1L): SharedFlow<T> =
    this.shareIn(
        scope = viewModel.viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = stopTimeoutMillis),
    )