package com.brbx.ui_compose.containers.scaffold

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.components.shimmer.BrbxShimmerBlock
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.mColors
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun BrbxShimmerScaffold(
    isShimmering: Boolean,
    modifier: Modifier = Modifier,
    appearance: BrbxShimmerScaffoldAppearance = BrbxShimmerScaffoldAppearances.default,
    isError: Boolean = false,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    errorContent: @Composable (PaddingValues) -> Unit = {},
    shimmerContent: @Composable (PaddingValues) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) =
    BrbxShimmerScaffoldImpl(
        isShimmering = isShimmering,
        modifier = modifier,
        appearance = appearance,
        isError = isError,
        topBar = topBar,
        bottomBar = bottomBar,
        snackbarHost = snackbarHost,
        floatingActionButton = floatingActionButton,
        errorContent = errorContent,
        content = content,
        shimmerContent = shimmerContent,
    )

@Composable
private fun BrbxShimmerScaffoldImpl(
    isShimmering: Boolean,
    modifier: Modifier,
    appearance: BrbxShimmerScaffoldAppearance,
    isError: Boolean,
    topBar: @Composable () -> Unit,
    bottomBar: @Composable () -> Unit,
    snackbarHost: @Composable () -> Unit,
    floatingActionButton: @Composable () -> Unit,
    errorContent: @Composable (PaddingValues) -> Unit,
    shimmerContent: @Composable (PaddingValues) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = topBar,
        bottomBar = bottomBar,
        snackbarHost = snackbarHost,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = appearance.floatingActionButtonPosition(),
        containerColor = appearance.containerColor(),
        contentColor = appearance.contentColor(),
        contentWindowInsets = appearance.contentWindowInsets(),
    ) { paddingValues ->
        Crossfade(
            targetState = isShimmering,
            animationSpec = appearance.crossfadeAnimationSpec(),
            label = "Shimmer crossfade",
        ) { targetIsShimmering ->
            if (targetIsShimmering) {
                shimmerContent(paddingValues)
            } else {
                if (errorContent != {} && isError) {
                    errorContent(paddingValues)
                } else {
                    content(paddingValues)
                }
            }
        }
    }
}

@Preview
@Composable
private fun BrbxShimmerScaffoldPreview() {
    BrbxTheme(colorScheme = darkColorScheme()) {
        var isShimmering by remember { mutableStateOf(true) }
        LaunchedEffect(key1 = isShimmering) {
            delay(duration = 3000.milliseconds)
            isShimmering = !isShimmering
        }

        val modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = bDimens.micro8)
            .clip(shape = RoundedCornerShape(size = bDimens.macro1))
        BrbxShimmerScaffold(
            isShimmering = isShimmering,
            shimmerContent = {
                Column(verticalArrangement = Arrangement.spacedBy(bDimens.micro6)) {
                    BrbxShimmerBlock(modifier)

                    BrbxShimmerBlock(modifier)

                    BrbxShimmerBlock(modifier)
                }
            },
            content = {
                Column(verticalArrangement = Arrangement.spacedBy(bDimens.micro6)) {
                    Box(modifier.background(color = mColors.primary))

                    Box(modifier.background(color = mColors.primary))

                    Box(modifier.background(color = mColors.primary))
                }
            },
        )
    }
}