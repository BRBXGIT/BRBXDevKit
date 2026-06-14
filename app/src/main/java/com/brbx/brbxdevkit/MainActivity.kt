package com.brbx.brbxdevkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.brbx.core.common.toBrbxText
import com.brbx.ui_compose.components.complex.precollection.precollection.BrbxPrecollection
import com.brbx.ui_compose.components.complex.searchable_top_bar.BrbxSearchableTopBar
import com.brbx.ui_compose.components.complex.tile.tile.BrbxTile
import com.brbx.ui_compose.components.complex.tile.tile.BrbxTileAppearances
import com.brbx.ui_compose.components.simple.brbx_switch.BrbxSwitch
import com.brbx.ui_compose.components.simple.image.BrbxIcon
import com.brbx.ui_compose.containers.container.container_with_badge.BrbxContainerWithBadge
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.mTypography
import dev.chiksmedina.solar.BoldSolar
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.bold.Users
import dev.chiksmedina.solar.bold.users.User
import dev.chiksmedina.solar.outline.Like
import dev.chiksmedina.solar.outline.Search
import dev.chiksmedina.solar.outline.Users
import dev.chiksmedina.solar.outline.like.Star
import dev.chiksmedina.solar.outline.search.Magnifer
import dev.chiksmedina.solar.outline.users.User

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var value by remember { mutableStateOf("") }
            var isSearching by remember { mutableStateOf(false) }
            BrbxTheme(lightColorScheme()) {
                Scaffold(
                    topBar = {
                        BrbxSearchableTopBar(
                            isSearching = isSearching,
                            onSystemBackClick = { isSearching = false },
                            title = "Title".toBrbxText(),
                            searchIcon = {
                                IconButton(
                                    onClick = { isSearching = true }
                                ) {
                                    BrbxIcon(imageVector = OutlineSolar.Search.Magnifer)
                                }
                            },
                            closeSearchIcon = {
                                IconButton(
                                    onClick = { isSearching = false }
                                ) {
                                    BrbxIcon(imageVector = OutlineSolar.Like.Star)
                                }
                            },
                            searchFieldPlaceholderText = "Input here...".toBrbxText(),
                            textFieldValue = { value },
                            onTextFieldValueChange = { value = it }
                        )
                    }
                ) { paddingValues ->
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(bDimens.micro4),
                        contentPadding = PaddingValues(
                            top = paddingValues.calculateTopPadding(),
                            bottom = paddingValues.calculateBottomPadding(),
                            end = bDimens.micro8,
                            start = bDimens.micro8,
                        )
                    ) {
                        item {
                            var checked by remember { mutableStateOf(false) }
                            BrbxSwitch(
                                checked = checked,
                                onCheckedChange = { checked = it }
                            )
                        }

                        item {
                            BrbxTile(
                                appearance = BrbxTileAppearances.elevated,
                                modifier = Modifier.fillMaxWidth(),
                                trailingContent = {
                                    BrbxContainerWithBadge(
                                        badgeContent = {
                                            Text(
                                                text = "4",
                                                style = mTypography.labelSmall,
                                                modifier = Modifier.padding(all = bDimens.micro3),
                                            )
                                        }
                                    ) {
                                        BrbxIcon(
                                            imageVector = BoldSolar.Users.User,
                                            modifier = Modifier.padding(all = bDimens.micro4),
                                        )
                                    }
                                },
                                title = "Some title".toBrbxText(),
                                description = "Some long description, it's very long and can not be in one line so it will be on second".toBrbxText(),
                                additionalContent = {
                                    BrbxPrecollection {
                                        Text(
                                            text = "Some long description, it's very long and can not rendered be in one line",
                                            style = mTypography.labelMedium,
                                            modifier = Modifier
                                                .weight(1f, fill = false)
                                                .padding(end = bDimens.micro4)
                                        )

                                        BrbxIcon(
                                            imageVector = OutlineSolar.Users.User,
                                        )
                                    }
                                }
                            )
                        }

                        item {
                            BrbxTile(
                                appearance = BrbxTileAppearances.elevated,
                                modifier = Modifier.fillMaxWidth(),
                                trailingContent = {
                                    BrbxContainerWithBadge {
                                        BrbxIcon(
                                            imageVector = BoldSolar.Users.User,
                                            modifier = Modifier.padding(all = bDimens.micro4),
                                        )
                                    }
                                },
                                title = "Some title".toBrbxText(),
                                description = "Some long description, it's very long and can not rendered be in one line".toBrbxText(),
                            )
                        }
                    }
                }
            }
        }
    }
}