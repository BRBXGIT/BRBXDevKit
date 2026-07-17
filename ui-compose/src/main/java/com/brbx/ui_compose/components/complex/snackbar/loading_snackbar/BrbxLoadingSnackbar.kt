package com.brbx.ui_compose.components.complex.snackbar.loading_snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.common.BrbxText
import com.brbx.ui_compose.common.asString
import com.brbx.ui_compose.common.toBrbxText
import com.brbx.ui_compose.components.complex.snackbar.common.BrbxSnackbarDuration
import com.brbx.ui_compose.components.complex.snackbar.loading_snackbar.appearance.BrbxLoadingSnackbarAppearance
import com.brbx.ui_compose.components.complex.snackbar.loading_snackbar.appearance.BrbxLoadingSnackbarAppearances
import com.brbx.ui_compose.components.complex.snackbar.loading_snackbar.config.BrbxLoadingSnackbarConfig
import com.brbx.ui_compose.containers.simple.omni_swipeable_container.BrbxDefaultSwipeConfig
import com.brbx.ui_compose.containers.simple.omni_swipeable_container.BrbxOmniSwipeableContainer
import com.brbx.ui_compose.containers.simple.omni_swipeable_container.BrbxSwipeConfig
import com.brbx.ui_compose.containers.simple.omni_swipeable_container.BrbxSwipeDirection
import com.brbx.ui_compose.theme.BrbxTheme

/**
 * A customizable loading snackbar component used to display background processes or tasks,
 * supporting swipe-to-dismiss gestures and visual styling configurations.
 *
 * @param isDismissable True if the snackbar can be dismissed by the user, false otherwise.
 * @param modifier The [Modifier] to be applied to the outer layout of this snackbar.
 * @param onDismiss Lambda callback invoked when the snackbar is dismissed (e.g., via swipe).
 * @param swipeConfig The configuration details determining swipe behavior, thresholds, and directions.
 * @param appearance The design and styling configuration (colors, shapes, typography) for the snackbar.
 * @param content The composable layout content to be rendered inside the snackbar, scoped to a [BoxScope].
 */
@Composable
fun BrbxLoadingSnackbar(
    isDismissable: Boolean,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {},
    swipeConfig: BrbxSwipeConfig = BrbxDefaultSwipeConfig(),
    appearance: BrbxLoadingSnackbarAppearance = BrbxLoadingSnackbarAppearances.default,
    content: @Composable BoxScope.() -> Unit,
) =
    BrbxLoadingSnackbarImpl(
        isDismissable = isDismissable,
        swipeConfig = swipeConfig,
        onDismiss = onDismiss,
        appearance = appearance,
        modifier = modifier,
        content = content,
    )

/**
 * A customizable loading snackbar component used to display background processes or tasks,
 * supporting swipe-to-dismiss gestures and visual styling configurations.
 *
 * @param config The configuration parameters for the loading snackbar.
 * @param modifier The [Modifier] to be applied to the outer layout of this snackbar.
 * @param onDismiss Lambda callback invoked when the snackbar is dismissed (e.g., via swipe).
 * @param swipeConfig The configuration details determining swipe behavior, thresholds, and directions.
 * @param appearance The design and styling configuration (colors, shapes, typography) for the snackbar.
 */
@Composable
fun BrbxLoadingSnackbar(
    config: BrbxLoadingSnackbarConfig,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {},
    swipeConfig: BrbxSwipeConfig = BrbxDefaultSwipeConfig(),
    appearance: BrbxLoadingSnackbarAppearance = BrbxLoadingSnackbarAppearances.default,
) =
    BrbxLoadingSnackbarImpl(
        swipeConfig = swipeConfig,
        isDismissable = config.isDismissable,
        onDismiss = onDismiss,
        appearance = appearance,
        modifier = modifier,
    ) { DefaultLoadingSnackbarContent(config, appearance) }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DefaultLoadingSnackbarContent(
    config: BrbxLoadingSnackbarConfig,
    appearance: BrbxLoadingSnackbarAppearance,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = appearance.containerShape(),
        color = Color.Transparent,
        shadowElevation = appearance.containerElevation(),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(appearance.contentHorizontalSpacing()),
            verticalAlignment = appearance.contentVerticalAlignment(),
            modifier = Modifier
                .background(brush = appearance.containerBrush())
                .fillMaxWidth()
                .padding(paddingValues = appearance.contentPadding()),
        ) {
            Text(
                modifier = Modifier.weight(weight = 1f),
                text = config.text.asString(),
                style = appearance.messageTextStyle(),
                maxLines = appearance.messageMaxLines(),
                overflow = appearance.messageOverflow(),
            )

            CircularWavyProgressIndicator(
                modifier = Modifier.size(size = appearance.indicatorSize()),
                color = appearance.indicatorColor(),
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BrbxLoadingSnackbarImpl(
    swipeConfig: BrbxSwipeConfig,
    isDismissable: Boolean,
    onDismiss: () -> Unit,
    appearance: BrbxLoadingSnackbarAppearance,
    modifier: Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    BrbxOmniSwipeableContainer(
        enabled = isDismissable,
        revertAnimationSpec = appearance.revertAnimationSpec(),
        dismissAnimationSpec = appearance.dismissAnimationSpec(),
        modifier = modifier,
        config = swipeConfig,
        onSwiped = { onDismiss() },
        content = content,
    )
}

@Preview
@Composable
private fun BrbxLoadingSnackbarPreview() {
    BrbxTheme(lightColorScheme()) {
        BrbxLoadingSnackbar(
            config = object : BrbxLoadingSnackbarConfig {
                override val id: Any = ""
                override val text: BrbxText = "Loading something important...".toBrbxText()
                override val duration: BrbxSnackbarDuration = BrbxSnackbarDuration.Infinite
                override val isDismissable: Boolean = true
            },
            onDismiss = {},
            swipeConfig = object : BrbxSwipeConfig {
                override val allowedDirections: Set<BrbxSwipeDirection> = setOf(
                    BrbxSwipeDirection.Up, BrbxSwipeDirection.Down,
                )
                override val swipeThreshold: Float = 300f
            },
        )
    }
}
