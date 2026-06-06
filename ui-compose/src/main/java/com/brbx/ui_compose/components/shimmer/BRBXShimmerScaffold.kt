package com.brbx.ui_compose.components.shimmer

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.theme.BRBXTheme
import com.brbx.ui_compose.theme.bColors
import kotlinx.coroutines.delay

private const val DefaultCrossfadeDuration = 500

@Composable
fun BRBXShimmerScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = contentColorFor(containerColor),
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
    isShimmering: Boolean,
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
            animationSpec = tween(durationMillis = DefaultCrossfadeDuration),
            label = "ShimmerCrossfade",
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
private fun BRBXShimmerScaffoldPreview() {
    BRBXTheme(darkColorScheme()) {
        var isShimmering by remember { mutableStateOf(true) }
        LaunchedEffect(isShimmering) {
            delay(3000)
            isShimmering = !isShimmering
        }

        val modifier = Modifier.size(200.dp, 200.dp)
        BRBXShimmerScaffold(
            containerColor = bColors.background,
            isShimmering = isShimmering,
            shimmerContent = {
                BRBXShimmerBlock(modifier)
            },
            content = {
                Box(modifier.background(bColors.primary))
            },
        )
    }
}