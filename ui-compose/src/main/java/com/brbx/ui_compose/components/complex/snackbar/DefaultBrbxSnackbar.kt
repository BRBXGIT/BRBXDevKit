package com.brbx.ui_compose.components.complex.snackbar

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.core.common.asString
import com.brbx.core.common.toBrbxText
import com.brbx.core.effects.snackbar.BrbxSnackbarConfig
import com.brbx.core.effects.snackbar.BrbxSnackbarDuration
import com.brbx.core.effects.snackbar.DefaultBrbxSnackbarConfig
import com.brbx.ui_compose.containers.swipeable_container.BrbxSwipeableContainer
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bElevation
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mColors
import com.brbx.ui_compose.theme.mTypography

@Composable
fun DefaultBrbxSnackbar(
    config: BrbxSnackbarConfig,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) =
    DefaultBrbxSnackbarImpl(
        config = config,
        onDismiss = onDismiss,
        modifier = modifier,
    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DefaultBrbxSnackbarImpl(
    config: BrbxSnackbarConfig,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BrbxSwipeableContainer(
        modifier = modifier,
        isSwipeable = config.isDismissable,
        onSwiped = { onDismiss() },
    ) {
        Surface(
            modifier = Modifier
                .padding(horizontal = bDimens.micro8, vertical = bDimens.micro4)
                .fillMaxWidth()
                .clip(shape = bShapes.micro2),
            color = mColors.surfaceContainer,
            shadowElevation = bElevation.small2,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(bDimens.micro2),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = bDimens.micro6,
                        horizontal = bDimens.micro6,
                    ),
            ) {
                Text(
                    text = config.text.asString(),
                    style = mTypography.bodyMedium.copy(
                        color = mColors.onSecondaryContainer
                    ),
                )

                if (config.buttonText != null && config.onButtonClick != null) {
                    TextButton(
                        modifier = Modifier.align(Alignment.End),
                        onClick = {
                            config.onButtonClick?.invoke()
                            onDismiss()
                        },
                    ) {
                        Text(
                            text = config.buttonText!!.asString(),
                            style = mTypography.labelLarge.copy(
                                fontWeight = FontWeight.W600,
                            ),
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun DefaultBrbxSnackbarPreview() {
    BrbxTheme(lightColorScheme()) {
        DefaultBrbxSnackbar(
            config = DefaultBrbxSnackbarConfig(
                text = "Bla bla snackbar blabla pizda zaebalo blabla djasfsdk".toBrbxText(),
                duration = BrbxSnackbarDuration.Long,
                buttonText = "Click".toBrbxText(),
                isDismissable = false,
                onButtonClick = {},
            ),
            onDismiss = {},
        )
    }
}