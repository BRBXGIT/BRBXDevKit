package com.brbx.ui_compose.components.card.appearance

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.theme.BRBXTheme

@Immutable
sealed class BRBXCardAppearance {

    abstract val width: BRBXCardWidth
    abstract val height: Dp
    abstract val titleMaxLines: Int
    abstract val descriptionMaxLines: Int

    open val shape: Shape
        @Composable get() = BRBXTheme.shapes.dp12
    open val background: Color
        @Composable get() = BRBXTheme.colorScheme.surface
    open val titleAppearance: TextStyle
        @Composable get() = BRBXTheme.typography.bodyMedium.copy(
            color = BRBXTheme.colorScheme.onTertiaryContainer,
            fontWeight = FontWeight.W600,
        )
    open val descriptionAppearance: TextStyle
        @Composable get() = BRBXTheme.typography.labelMedium.copy(
            color = BRBXTheme.colorScheme.secondary,
        )

    data class Medium(
        override val width: BRBXCardWidth.Fixed = BRBXCardWidth.Fixed(value = 150.dp),
        override val height: Dp = 270.dp,
        override val titleMaxLines: Int = 1,
        override val descriptionMaxLines: Int = 1,
    ) : BRBXCardAppearance() {

        val footerBackground: Color
            @Composable get() = BRBXTheme.colorScheme.tertiaryContainer
        val footerPadding: Dp
            @Composable get() = BRBXTheme.dimens.dp8
        val footerSpacedBy: Dp
            @Composable get() = BRBXTheme.dimens.dp4
    }
}