package com.brbx.core.coroutines

import androidx.annotation.CheckResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

internal typealias CoroutineAction = suspend CoroutineScope.() -> Unit
internal typealias CoroutineFinally = () -> Unit
internal typealias CoroutineError = Throwable.() -> Unit

// TODO Make module kotlin library with kotlix coroutine library
/**
 * An intermediate builder unit for the Brbx coroutine DSL.
 *
 * This interface encapsulates the state required to launch a coroutine with structured
 * error handling. It holds the scope and the action to be executed, and is designed
 * to be consumed by the [onError] infix function to actually trigger the launch.
 */
interface BrbxCoroutineUnit {
    val scope: CoroutineScope
    val coroutineAction: CoroutineAction
    val coroutineFinally: CoroutineFinally?
}

internal data class DefaultBrbxCoroutineUnit(
    override val scope: CoroutineScope,
    override val coroutineAction: CoroutineAction,
    override val coroutineFinally: CoroutineFinally? = null,
) : BrbxCoroutineUnit

/**
 * Initiates the Brbx coroutine launch DSL.
 *
 * This function **does not** immediately start the coroutine. Instead, it returns a
 * [BrbxCoroutineUnit] that must be chained with [onError] to execute the coroutine.
 * * Example usage:
 * ```kotlin
 * viewModelScope onLaunch {
 * // Suspending code here
 * } onError {
 * // Work and handle exception (this refers to the Throwable)
 * } onFinally {
 * // Cleanup work
 * }
 * ```
 *
 * @param action The primary suspending block of code to execute.
 * @return An intermediate [BrbxCoroutineUnit] that must be consumed to execute the action.
 */
@CheckResult
fun CoroutineScope.onLaunch(action: CoroutineAction): BrbxCoroutineUnit =
    DefaultBrbxCoroutineUnit(scope = this, coroutineAction = action)

/**
 * Executes the coroutine action defined in the [BrbxCoroutineUnit] and defines the error handler.
 *
 * This is the terminal operation of the DSL that actually triggers the underlying coroutine
 * builder (via `tryLaunch`).
 *
 * @receiver The intermediate state built by [onLaunch].
 * @param doOnError The block to execute if the coroutine throws a [Throwable].
 * @return The [Job] representing the active coroutine.
 */
infix fun BrbxCoroutineUnit.onError(doOnError: CoroutineError): Job =
    scope.tryLaunch(
        doOnLaunch = coroutineAction,
        doOnError = doOnError,
        doFinally = coroutineFinally
    )

/**
 * Attaches a completion handler to a coroutine [Job].
 *
 * This block will be invoked exactly once when the job completes, regardless of whether
 * it finished normally, was canceled, or failed with an exception.
 *
 * @receiver The [Job] returned by the coroutine launch.
 * @param finally The cleanup or completion block to execute.
 * @return The original [Job] to allow for further chaining if needed.
 */
infix fun Job.onFinally(finally: CoroutineFinally): Job =
    apply {
        invokeOnCompletion { finally() }
    }