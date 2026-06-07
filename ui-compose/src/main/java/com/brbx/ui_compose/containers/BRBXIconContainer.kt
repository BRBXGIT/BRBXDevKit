package com.brbx.ui_compose.containers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.brbx.ui_compose.theme.bColors
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bShapes

@Composable
fun BRBXIconContainer(
    modifier: Modifier = Modifier,
    shape: Shape = bShapes.circle,
    containerColor: Color = bColors.primary,
    contentColor: Color = bColors.onPrimary,
    contentPadding: Dp = bDimens.dp8,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                color = containerColor,
                shape = shape,
            )
            .padding(contentPadding),
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            content()
        }
    }
}