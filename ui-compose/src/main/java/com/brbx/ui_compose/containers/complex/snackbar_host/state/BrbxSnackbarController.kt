package com.brbx.ui_compose.containers.complex.snackbar_host.state

import androidx.compose.runtime.Stable
import com.brbx.ui_compose.components.complex.snackbar.common.BrbxSnackbarConfig

/**
 * Controller responsible for triggering the display of snackbars.
 * * Separating this interface from the state holder allows you to expose only the
 * dispatching mechanism (e.g., to ViewModels or lower-level UI components)
 * without exposing internal state management or lifecycle methods.
 */
@Stable
interface BrbxSnackbarController {

    fun show(config: BrbxSnackbarConfig)

    fun dismissCurrent()

    fun removeById(id: Any)
}