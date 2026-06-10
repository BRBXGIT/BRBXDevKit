package com.brbx.core.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn

context(coroutineScope: CoroutineScope)
fun <T> Flow<T>.stateInEagerly(initialValue: T): StateFlow<T> =
    this.stateIn(
        scope = coroutineScope,
        started = SharingStarted.Eagerly,
        initialValue = initialValue,
    )

context(coroutineScope: CoroutineScope)
fun <T> Flow<T>.stateInLazily(initialValue: T): StateFlow<T> =
    this.stateIn(
        scope = coroutineScope,
        started = SharingStarted.Lazily,
        initialValue = initialValue,
    )

context(coroutineScope: CoroutineScope)
fun <T> Flow<T>.stateInWhileSubscribed(
    initialValue: T,
    stopTimeoutMillis: Long = 1L,
): StateFlow<T> =
    this.stateIn(
        scope = coroutineScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = stopTimeoutMillis),
        initialValue = initialValue,
    )

context(coroutineScope: CoroutineScope)
fun <T> Flow<T>.shareInEagerly(): SharedFlow<T> =
    this.shareIn(
        scope = coroutineScope,
        started = SharingStarted.Eagerly,
    )

context(coroutineScope: CoroutineScope)
fun <T> Flow<T>.shareInLazily(): SharedFlow<T> =
    this.shareIn(
        scope = coroutineScope,
        started = SharingStarted.Lazily,
    )

context(coroutineScope: CoroutineScope)
fun <T> Flow<T>.shareInWhileSubscribed(stopTimeoutMillis: Long = 1L): SharedFlow<T> =
    this.shareIn(
        scope = coroutineScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = stopTimeoutMillis),
    )