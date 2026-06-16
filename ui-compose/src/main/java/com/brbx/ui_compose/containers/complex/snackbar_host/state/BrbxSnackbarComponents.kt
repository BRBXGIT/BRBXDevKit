package com.brbx.ui_compose.containers.complex.snackbar_host.state

/**
 * A container holding the paired [BrbxSnackbarController] and [BrbxSnackbarHostState].
 * * This is typically used to easily provide both the dispatching mechanism and the
 * state-holding mechanism through a `CompositionLocal` or Dependency Injection.
 *
 * @property controller The controller used to dispatch snackbar show requests.
 * @property hostState The state holder used by the UI host to render the snackbars.
 */
class BrbxSnackbarComponents internal constructor(
    val controller: BrbxSnackbarController,
    val hostState: BrbxSnackbarHostState,
)