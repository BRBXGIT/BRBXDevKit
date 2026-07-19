package com.brbx.ui_compose.components.complex.snackbar.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.brbx.ui_compose.common.BrbxText
import com.brbx.ui_compose.common.asString
import com.brbx.ui_compose.common.toBrbxText
import com.brbx.ui_compose.components.complex.snackbar.common.BrbxSnackbarDuration
import com.brbx.ui_compose.components.complex.snackbar.snackbar.appearance.BrbxInfoSnackbarAppearance
import com.brbx.ui_compose.components.complex.snackbar.snackbar.appearance.BrbxInfoSnackbarAppearances
import com.brbx.ui_compose.components.complex.snackbar.snackbar.config.BrbxInfoSnackbarConfig
import com.brbx.ui_compose.containers.simple.omni_swipeable_container.BrbxDefaultSwipeConfig
import com.brbx.ui_compose.containers.simple.omni_swipeable_container.BrbxOmniSwipeableContainer
import com.brbx.ui_compose.containers.simple.omni_swipeable_container.BrbxSwipeConfig
import com.brbx.ui_compose.containers.simple.omni_swipeable_container.BrbxSwipeDirection
import com.brbx.ui_compose.theme.BrbxTheme
import kotlin.math.max

/**
 * A customizable snackbar component used to display transient messages,
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
fun BrbxInfoSnackbar(
    isDismissable: Boolean,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {},
    swipeConfig: BrbxSwipeConfig = BrbxDefaultSwipeConfig(),
    appearance: BrbxInfoSnackbarAppearance = BrbxInfoSnackbarAppearances.default,
    content: @Composable BoxScope.() -> Unit,
) =
    BrbxSnackbarImpl(
        isDismissable = isDismissable,
        swipeConfig = swipeConfig,
        onDismiss = onDismiss,
        appearance = appearance,
        modifier = modifier,
        content = content,
    )

@Composable
fun BrbxInfoSnackbar(
    config: BrbxInfoSnackbarConfig,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {},
    swipeConfig: BrbxSwipeConfig = BrbxDefaultSwipeConfig(),
    appearance: BrbxInfoSnackbarAppearance = BrbxInfoSnackbarAppearances.default,
) =
    BrbxSnackbarImpl(
        swipeConfig = swipeConfig,
        isDismissable = config.isDismissable,
        onDismiss = onDismiss,
        appearance = appearance,
        modifier = modifier,
    ) { DefaultSnackbarContent(onDismiss, config, appearance) }

@Composable
private fun DefaultSnackbarContent(
    onDismiss: () -> Unit,
    config: BrbxInfoSnackbarConfig,
    appearance: BrbxInfoSnackbarAppearance,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = appearance.containerShape(),
        color = Color.Transparent,
        shadowElevation = appearance.containerElevation(),
    ) {
        ResponsiveSnackbarLayout(
            actionAlignment = appearance.actionAlignment(),
            spacing = appearance.contentVerticalSpacing(),
            modifier = Modifier
                .background(brush = appearance.containerBrush())
                .fillMaxWidth()
                .padding(paddingValues = appearance.contentPadding())
        ) {
            Text(
                text = config.text.asString(),
                style = appearance.messageTextStyle(),
                maxLines = appearance.messageMaxLines(),
                overflow = appearance.messageOverflow(),
            )

            if (config.buttonText != null && config.onButtonClick != null) {
                TextButton(
                    onClick = {
                        config.onButtonClick?.invoke()
                        onDismiss()
                    },
                ) {
                    Text(
                        text = config.buttonText!!.asString(),
                        style = appearance.actionTextStyle(),
                    )
                }
            }
        }
    }
}

@Composable
private fun ResponsiveSnackbarLayout(
    actionAlignment: Alignment.Horizontal,
    spacing: Dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content,
    ) { measurables, constraints ->
        val spacingPx = spacing.roundToPx()
        val textMeasurable = measurables.first()

        if (measurables.size == 1) {
            val text = textMeasurable.measure(constraints)
            return@Layout layout(constraints.maxWidth, text.height) {
                text.placeRelative(0, 0)
            }
        }

        val action = measurables[1].measure(
            constraints.copy(
                minWidth = 0,
                minHeight = 0,
            )
        )

        val availableTextWidth =
            (constraints.maxWidth - action.width - spacingPx).coerceAtLeast(0)
        val shouldPlaceHorizontally =
            textMeasurable.maxIntrinsicWidth(constraints.maxHeight) <= availableTextWidth

        if (shouldPlaceHorizontally) {
            val text = textMeasurable.measure(
                constraints.copy(
                    minWidth = 0,
                    maxWidth = availableTextWidth,
                )
            )

            val height = max(text.height, action.height)

            layout(constraints.maxWidth, height) {
                text.placeRelative(
                    x = 0,
                    y = (height - text.height) / 2,
                )
                action.placeRelative(
                    x = constraints.maxWidth - action.width,
                    y = (height - action.height) / 2,
                )
            }
        } else {
            val text = textMeasurable.measure(
                constraints.copy(minWidth = 0)
            )

            val height = text.height + spacingPx + action.height

            layout(constraints.maxWidth, height) {
                text.placeRelative(0, 0)
                action.placeRelative(
                    x = actionAlignment.align(
                        size = action.width,
                        space = constraints.maxWidth,
                        layoutDirection = layoutDirection,
                    ),
                    y = text.height + spacingPx,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BrbxSnackbarImpl(
    swipeConfig: BrbxSwipeConfig,
    isDismissable: Boolean,
    onDismiss: () -> Unit,
    appearance: BrbxInfoSnackbarAppearance,
    modifier: Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    // TODO Add base swipe offset after which snackbar should be hidden
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
private fun BrbxSnackbarPreview() {
    BrbxTheme(lightColorScheme()) {
        BrbxInfoSnackbar(
            config = object : BrbxInfoSnackbarConfig {
                override val id: Any = ""
                override val text: BrbxText = "Some text balblba again aging blablbb fdsdfj againg text".toBrbxText()
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
            },
        )
    }
}