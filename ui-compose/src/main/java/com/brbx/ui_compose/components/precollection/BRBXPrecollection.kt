package com.brbx.ui_compose.components.precollection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.components.image.BRBXIcon
import com.brbx.ui_compose.components.precollection.appearance.BRBXPrecollectionAppearance
import com.brbx.ui_compose.components.precollection.appearance.BRBXPrecollectionAppearances
import com.brbx.ui_compose.theme.BRBXTheme
import com.brbx.ui_compose.theme.bDimens
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.Users
import dev.chiksmedina.solar.outline.users.User

@Composable
fun BRBXPrecollection(
    text: String,
    modifier: Modifier = Modifier,
    appearance: BRBXPrecollectionAppearance = BRBXPrecollectionAppearances.tertiary,
    leadingContent: @Composable () -> Unit = {},
) {
    Row(
        modifier = modifier
            .clip(shape = appearance.containerShape())
            .background(brush = appearance.containerBrush())
            .padding(paddingValues = appearance.contentPadding()),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            overflow = appearance.textOverflow(),
            maxLines = appearance.textMaxLines(),
            style = appearance.textStyle(),
            text = text,
            modifier = Modifier
                .weight(1f, fill = false)
                .padding(end = appearance.textEndPadding())
        )

        CompositionLocalProvider(
            LocalContentColor provides appearance.leadingContentColor()
        ) {
            leadingContent()
        }
    }
}

@Preview
@Composable
private fun BRBXPrecollectionPreview() {
    BRBXTheme(colorScheme = lightColorScheme()) {
        BRBXPrecollection(
            appearance = BRBXPrecollectionAppearances.secondary,
            text = "Long text blablabla long text long long bla text bla",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = bDimens.dp16)
        ) {
            BRBXIcon(OutlineSolar.Users.User)
        }
    }
}