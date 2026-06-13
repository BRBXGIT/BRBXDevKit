package com.brbx.core.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

/**
 * Safely launches a coroutine with built-in exception handling and an optional completion block.
 *
 * This extension function acts as a robust wrapper around the standard [launch] builder.
 * It automatically injects a [CoroutineExceptionHandler] to catch and route exceptions, and
 * it executes the primary action within a [supervisorScope]. This ensures that if child
 * coroutines fail, they do not automatically cancel the parent scope or other siblings,
 * while still routing unhandled exceptions to the provided error handler.
 *
 * @param doOnLaunch The primary suspending block of code to execute within the coroutine.
 * @param doOnError A callback invoked if an unhandled exception is thrown during execution.
 * The receiver of this block is the thrown [Throwable].
 * @param doFinally An optional cleanup callback invoked exactly once when the coroutine completes,
 * regardless of whether it finished normally, failed with an exception, or was canceled.
 * @return The [Job] representing the active coroutine, allowing for further lifecycle management.
 */
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