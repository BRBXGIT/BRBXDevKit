package com.brbx.ui_compose.containers.scaffold

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerBlock
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bAnimationTokens
import com.brbx.ui_compose.theme.mColors
import com.brbx.ui_compose.theme.bDimens
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

/**
 * A customized [Scaffold] that smoothly transitions between a loading state and main content.
 *
 * This component wraps the standard Material [Scaffold] and uses a [Crossfade] animation
 * to switch between the [shimmerContent] and the actual [content] based on the [isShimmering] flag.
 * It is highly useful for screens that require a skeleton or shimmer loading effect while fetching data,
 * keeping the standard layout elements (like top bars and FABs) static.
 *
 * @param isShimmering Determines whether to show the [shimmerContent] (`true`) or the actual [content] (`false`).
 * @param modifier The modifier to be applied to the scaffold container.
 * @param topBar Top app bar of the screen.
 * @param bottomBar Bottom bar of the screen.
 * @param snackbarHost Component to host snackbars.
 * @param floatingActionButton Main action button of the screen.
 * @param floatingActionButtonPosition Position of the [floatingActionButton] on the screen.
 * @param containerColor The background color of the scaffold itself.
 * @param contentColor The preferred color for content inside this scaffold.
 * @param contentWindowInsets Window insets to be passed to the content slots.
 * @param crossfadeDuration The duration (in milliseconds) of the crossfade animation between states.
 * @param shimmerContent The composable representing the loading state (e.g., skeleton UI). Receives the inner padding.
 * @param content The composable representing the main UI when data is loaded. Receives the inner padding.
 */
@Composable
fun BrbxShimmerScaffold(
    isShimmering: Boolean,
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    containerColor: Color = mColors.background,
    contentColor: Color = contentColorFor(containerColor),
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
    crossfadeDuration: Int = bAnimationTokens.duration500.toInt(),
    shimmerContent: @Composable (PaddingValues) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    BrbxShimmerScaffoldImpl(
        isShimmering = isShimmering,
        modifier = modifier,
        topBar = topBar,
        bottomBar = bottomBar,
        snackbarHost = snackbarHost,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = floatingActionButtonPosition,
        containerColor = containerColor,
        contentColor = contentColor,
        contentWindowInsets = contentWindowInsets,
        crossfadeDuration = crossfadeDuration,
        content = content,
        shimmerContent = shimmerContent,
    )
}

@Composable
fun BrbxShimmerScaffoldImpl(
    isShimmering: Boolean,
    modifier: Modifier,
    topBar: @Composable () -> Unit,
    bottomBar: @Composable () -> Unit,
    snackbarHost: @Composable () -> Unit,
    floatingActionButton: @Composable () -> Unit,
    floatingActionButtonPosition: FabPosition,
    containerColor: Color,
    contentColor: Color,
    contentWindowInsets: WindowInsets,
    crossfadeDuration: Int,
    shimmerContent: @Composable (PaddingValues) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = topBar,
        bottomBar = bottomBar,
        snackbarHost = snackbarHost,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = floatingActionButtonPosition,
        containerColor = containerColor,
        contentColor = contentColor,
        contentWindowInsets = contentWindowInsets,
    ) { paddingValues ->
        Crossfade(
            targetState = isShimmering,
            animationSpec = tween(crossfadeDuration),
            label = "Shimmer crossfade",
        ) { targetIsShimmering ->
            if (targetIsShimmering) {
                shimmerContent(paddingValues)
            } else {
                content(paddingValues)
            }
        }
    }
}

@Preview
@Composable
private fun BrbxShimmerScaffoldPreview() {
    BrbxTheme(colorScheme = darkColorScheme()) {
        var isShimmering by remember { mutableStateOf(true) }
        LaunchedEffect(isShimmering) {
            delay(3000.milliseconds)
            isShimmering = !isShimmering
        }

        val modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = bDimens.dp16)
            .clip(shape = RoundedCornerShape(size = bDimens.dp20))
        BrbxShimmerScaffold(
            containerColor = mColors.background,
            isShimmering = isShimmering,
            shimmerContent = {
                Column(verticalArrangement = Arrangement.spacedBy(bDimens.dp12)) {
                    BrbxShimmerBlock(modifier)

                    BrbxShimmerBlock(modifier)

                    BrbxShimmerBlock(modifier)
                }
            },
            content = {
                Column(verticalArrangement = Arrangement.spacedBy(bDimens.dp12)) {
                    Box(modifier.background(color = mColors.primary))

                    Box(modifier.background(color = mColors.primary))

                    Box(modifier.background(color = mColors.primary))
                }
            },
        )
    }
}