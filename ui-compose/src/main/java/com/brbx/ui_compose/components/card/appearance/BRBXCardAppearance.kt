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
sealed interface BRBXCardAppearance {

    val width: BRBXCardWidth
    val height: Dp
    val shape: Shape
        @Composable get
    val background: Color
        @Composable get
    val titleAppearance: TextStyle
        @Composable get
    val descriptionAppearance: TextStyle
        @Composable get

    val titleMaxLines: Int
    val descriptionMaxLines: Int

    data class Medium(
        override val width: BRBXCardWidth.Fixed = BRBXCardWidth.Fixed(value = 150.dp),
        override val height: Dp = 270.dp,
        override val titleMaxLines: Int = 1,
        override val descriptionMaxLines: Int = 1,
    ) : BRBXCardAppearance {

        override val shape: Shape
            @Composable get() = BRBXTheme.shapes.dp12
        override val background: Color
            @Composable get() = BRBXTheme.colorScheme.surface
        override val titleAppearance: TextStyle
            @Composable get() = BRBXTheme.typography.bodyMedium.copy(
                color = BRBXTheme.colorScheme.onTertiaryContainer,
                fontWeight = FontWeight.W600,
            )
        override val descriptionAppearance: TextStyle
            @Composable get() = BRBXTheme.typography.labelMedium.copy(
                color = BRBXTheme.colorScheme.secondary,
            )

        val footerBackground: Color
            @Composable get() = BRBXTheme.colorScheme.tertiaryContainer

        val footerPadding: Dp
            @Composable get() = BRBXTheme.dimens.dp8
        val footerSpacedBy: Dp
            @Composable get() = BRBXTheme.dimens.dp4
    }

    data class Small(
        override val width: BRBXCardWidth.MaxWidth = BRBXCardWidth.MaxWidth,
        override val height: Dp = 74.dp,
        override val titleMaxLines: Int = 1,
        override val descriptionMaxLines: Int = 2,
    ) : BRBXCardAppearance {

        override val shape: Shape
            @Composable get() = BRBXTheme.shapes.dp12
        override val background: Color
            @Composable get() = BRBXTheme.colorScheme.surface
        override val titleAppearance: TextStyle
            @Composable get() = BRBXTheme.typography.bodyMedium.copy(
                color = BRBXTheme.colorScheme.onTertiaryContainer,
                fontWeight = FontWeight.W600,
            )
        override val descriptionAppearance: TextStyle
            @Composable get() = BRBXTheme.typography.labelMedium.copy(
                color = BRBXTheme.colorScheme.secondary,
            )

        val iconBackground: Color
            @Composable get() = BRBXTheme.colorScheme.primary
        val iconTint: Color
            @Composable get() = BRBXTheme.colorScheme.onPrimary
        val iconPadding: Dp
            @Composable get() = BRBXTheme.dimens.dp8
        val iconBackgroundShape: Shape
            @Composable get() = BRBXTheme.shapes.circle
        val horizontalPadding: Dp
            @Composable get() = BRBXTheme.dimens.dp16
        val innerPadding: Dp
            @Composable get() = BRBXTheme.dimens.dp16

        val rowSpacedBy: Dp
            @Composable get() = BRBXTheme.dimens.dp16
        val columnSpacedBy: Dp
            @Composable get() = BRBXTheme.dimens.dp2
    }
}