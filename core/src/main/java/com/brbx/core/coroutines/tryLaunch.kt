package com.brbx.core.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

fun CoroutineScope.tryLaunch(
    doOnLaunch: suspend CoroutineScope.() -> Unit,
    doOnError: Throwable.() -> Unit,
    doFinally: (() -> Unit)? = null
): Job =
    launch(
        context = CoroutineExceptionHandler { _, throwable ->
            throwable.doOnError()
        }
    ) {
        supervisorScope { doOnLaunch() }
    }.apply {
        doFinally?.let { doFinally ->
            invokeOnCompletion {
                doFinally()
            }
        }
    }