package com.brbx.core.coroutines

import androidx.annotation.CheckResult
import androidx.compose.runtime.Immutable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

typealias CoroutineAction = suspend CoroutineScope.() -> Unit
typealias CoroutineFinally = () -> Unit
typealias CoroutineError = Throwable.() -> Unit

@Immutable
data class CoroutineUnit(
    val scope: CoroutineScope,
    val coroutineAction: CoroutineAction,
    val coroutineFinally: CoroutineFinally? = null,
)

@CheckResult
fun CoroutineScope.onLaunch(action: CoroutineAction) =
    CoroutineUnit(scope = this, coroutineAction = action)

infix fun CoroutineUnit.onError(doOnError: CoroutineError): Job =
    scope.launch {
        tryLaunch(
            doOnLaunch = coroutineAction,
            doOnError = doOnError,
            doFinally = coroutineFinally
        )
    }

infix fun Job.onFinally(finally: CoroutineFinally): Job =
    apply {
        invokeOnCompletion { finally() }
    }