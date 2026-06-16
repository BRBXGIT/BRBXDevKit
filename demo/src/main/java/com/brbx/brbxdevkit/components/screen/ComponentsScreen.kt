package com.brbx.brbxdevkit.components.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.brbx.brbxdevkit.components.view_model.ComponentsIntent
import com.brbx.mvi_compose.effects.BrbxEffect
import com.brbx.ui_compose.common.toBrbxText
import com.brbx.ui_compose.components.complex.searchable_top_bar.BrbxSearchableTopBar
import com.brbx.ui_compose.components.complex.snackbar.config.DefaultBrbxSnackbarConfig
import com.brbx.ui_compose.components.complex.tile.tile.BrbxTile
import com.brbx.ui_compose.components.complex.tile.tile.BrbxTileAppearances
import com.brbx.ui_compose.components.simple.icon.BrbxIcon
import com.brbx.ui_compose.containers.complex.container.container_with_badge.BrbxContainerWithBadge
import com.brbx.ui_compose.containers.complex.snackbar_host.BrbxSnackbarHost
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.mTypography
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.EssentionalUi
import dev.chiksmedina.solar.outline.Search
import dev.chiksmedina.solar.outline.Users
import dev.chiksmedina.solar.outline.essentionalui.CloseCircle
import dev.chiksmedina.solar.outline.search.Magnifer
import dev.chiksmedina.solar.outline.users.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentsScreen(
    dispatchIntent: (intent: ComponentsIntent) -> Unit,
    dispatchBrbxEffect: (effect: BrbxEffect) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    var isSearching by remember { mutableStateOf(false) }
    var searchValue by remember { mutableStateOf("") }
    Scaffold(
        snackbarHost = { BrbxSnackbarHost() },
        topBar = {
            BrbxSearchableTopBar(
                isSearching = isSearching,
                scrollBehavior = scrollBehavior,
                onSystemBackClick = { isSearching = false },
                title = "Components".toBrbxText(),
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
                        BrbxIcon(imageVector = OutlineSolar.EssentionalUi.CloseCircle)
                    }
                },
                searchFieldPlaceholderText = "Search here...".toBrbxText(),
                textFieldValue = { searchValue },
                onTextFieldValueChange = { searchValue = it },
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { paddingValues ->
        val tileAppearance = BrbxTileAppearances.elevated
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(all = bDimens.micro4),
            verticalArrangement = Arrangement.spacedBy(bDimens.micro4),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                BrbxTile(
                    onClick = {
                        dispatchBrbxEffect(
                            BrbxEffect.ShowSnackbar(
                                config = DefaultBrbxSnackbarConfig(
                                    text = "This is default brbx snackbar youou".toBrbxText()
                                )
                            )
                        )
                    },
                    appearance = tileAppearance,
                    title = "This is title".toBrbxText(),
                    description = "This is some description, click on tile to show a snackbar".toBrbxText()
                ) {
                    BrbxContainerWithBadge(
                        badgeContent = {
                            Text(
                                text = "8",
                                style = mTypography.labelLarge,
                                modifier = Modifier.padding(all = bDimens.micro2)
                            )
                        }
                    ) {
                        BrbxIcon(
                            imageVector = OutlineSolar.Users.User,
                            modifier = Modifier.padding(all = bDimens.micro4)
                        )
                    }
                }
            }
        }
    }
}