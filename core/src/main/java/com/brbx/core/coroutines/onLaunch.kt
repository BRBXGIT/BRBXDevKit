package com.brbx.core.coroutines

import androidx.annotation.CheckResult
import androidx.compose.runtime.Immutable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

internal typealias CoroutineAction = suspend CoroutineScope.() -> Unit
internal typealias CoroutineFinally = () -> Unit
internal typealias CoroutineError = Throwable.() -> Unit

@Immutable
interface BrbxCoroutineUnit {
    val scope: CoroutineScope
    val coroutineAction: CoroutineAction
    val coroutineFinally: CoroutineFinally?
}

@Immutable
internal data class DefaultBrbxCoroutineUnit(
    override val scope: CoroutineScope,
    override val coroutineAction: CoroutineAction,
    override val coroutineFinally: CoroutineFinally? = null,
) : BrbxCoroutineUnit

@CheckResult
fun CoroutineScope.onLaunch(action: CoroutineAction): BrbxCoroutineUnit =
    DefaultBrbxCoroutineUnit(scope = this, coroutineAction = action)

infix fun BrbxCoroutineUnit.onError(doOnError: CoroutineError): Job =
    scope.tryLaunch(
        doOnLaunch = coroutineAction,
        doOnError = doOnError,
        doFinally = coroutineFinally
    )

infix fun Job.onFinally(finally: CoroutineFinally): Job =
    apply {
        invokeOnCompletion { finally() }
    }