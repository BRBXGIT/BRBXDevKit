package com.brbx.ui_compose.components.complex.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.common.BrbxText
import com.brbx.ui_compose.common.asString
import com.brbx.ui_compose.common.toBrbxText
import com.brbx.ui_compose.components.complex.snackbar.config.BrbxSnackbarConfig
import com.brbx.ui_compose.components.complex.snackbar.config.BrbxSnackbarDuration
import com.brbx.ui_compose.containers.simple.omni_swipeable_container.BrbxDefaultSwipeConfig
import com.brbx.ui_compose.containers.simple.omni_swipeable_container.BrbxOmniSwipeableContainer
import com.brbx.ui_compose.containers.simple.omni_swipeable_container.BrbxSwipeConfig
import com.brbx.ui_compose.containers.simple.omni_swipeable_container.BrbxSwipeDirection
import com.brbx.ui_compose.theme.BrbxTheme

/**
 * A customizable Snackbar component designed to display brief, transient messages to the user.
 * * It supports multi-directional swipe-to-dismiss functionality (powered by [BrbxOmniSwipeableContainer])
 * and optional actionable buttons. The appearance and behavior are fully decoupled, allowing for
 * flexible styling and configuration.
 *
 * @param config The core data model ([BrbxSnackbarConfig]) containing the message text, optional action button details, and dismissibility state.
 * @param onDismiss A callback invoked when the Snackbar is dismissed. This triggers either through a successful swipe gesture or when the action button is clicked.
 * @param modifier The [Modifier] to be applied to the outermost layout of the Snackbar.
 * @param swipeConfig Configuration defining allowed swipe directions and thresholds. Defaults to [BrbxDefaultSwipeConfig].
 * @param appearance A styling interface ([BrbxSnackbarAppearance]) dictating the visual design (colors, typography, shapes, margins). Defaults to standard appearances.
 */
@Composable
fun BrbxSnackbar(
    config: BrbxSnackbarConfig,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    swipeConfig: BrbxSwipeConfig = BrbxDefaultSwipeConfig(),
    appearance: BrbxSnackbarAppearance = BrbxSnackbarAppearances.default,
) =
    BrbxSnackbarImpl(
        swipeConfig = swipeConfig,
        snackbarConfig = config,
        onDismiss = onDismiss,
        appearance = appearance,
        modifier = modifier,
    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BrbxSnackbarImpl(
    swipeConfig: BrbxSwipeConfig,
    snackbarConfig: BrbxSnackbarConfig,
    onDismiss: () -> Unit,
    appearance: BrbxSnackbarAppearance,
    modifier: Modifier,
) {
    // TODO Add base swipe offset after which snackbar should be hidden
    BrbxOmniSwipeableContainer(
        enabled = snackbarConfig.isDismissable,
        revertAnimationSpec = appearance.revertAnimationSpec(),
        dismissAnimationSpec = appearance.dismissAnimationSpec(),
        modifier = modifier,
        config = swipeConfig,
        onSwiped = { onDismiss() },
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = appearance.containerShape(),
            color = Color.Transparent,
            shadowElevation = appearance.containerElevation(),
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(appearance.contentVerticalSpacing()),
                modifier = Modifier
                    .background(brush = appearance.containerBrush())
                    .fillMaxWidth()
                    .padding(paddingValues = appearance.contentPadding()),
            ) {
                Text(
                    text = snackbarConfig.text.asString(),
                    style = appearance.messageTextStyle(),
                    maxLines = appearance.messageMaxLines(),
                    overflow = appearance.messageOverflow(),
                )

                if (snackbarConfig.buttonText != null && snackbarConfig.onButtonClick != null) {
                    TextButton(
                        modifier = Modifier.align(alignment = appearance.actionAlignment()),
                        onClick = {
                            snackbarConfig.onButtonClick?.invoke()
                            onDismiss()
                        },
                    ) {
                        Text(
                            text = snackbarConfig.buttonText!!.asString(),
                            style = appearance.actionTextStyle(),
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun BrbxSnackbarPreview() {
    BrbxTheme(lightColorScheme()) {
        BrbxSnackbar(
            config = object : BrbxSnackbarConfig {
                override val text: BrbxText = "Some text balblba again aging blablbb fdsdfj againg text gagi".toBrbxText()
                override val duration: BrbxSnackbarDuration = BrbxSnackbarDuration.Short
                override val isDismissable: Boolean = false
                override val buttonText: BrbxText = "Click".toBrbxText()
                override val onButtonClick: (() -> Unit) = {}
            },
            onDismiss = {},
            swipeConfig = object : BrbxSwipeConfig {
                override val allowedDirections: Set<BrbxSwipeDirection> = setOf(
                    BrbxSwipeDirection.Up, BrbxSwipeDirection.Down,
                )
                override val swipeThreshold: Float = 300f
            }
        )
    }
}