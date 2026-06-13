package com.brbx.brbxdevkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.brbx.core.common.toBrbxText
import com.brbx.ui_compose.components.complex.searchable_top_bar.BrbxSearchableTopBar
import com.brbx.ui_compose.components.simple.image.BrbxIcon
import com.brbx.ui_compose.theme.BrbxTheme
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.Like
import dev.chiksmedina.solar.outline.Search
import dev.chiksmedina.solar.outline.like.Star
import dev.chiksmedina.solar.outline.search.Magnifer

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val theme = if (isSystemInDarkTheme()) {
                darkColorScheme()
            } else {
                lightColorScheme()
            }

            var value by remember { mutableStateOf("") }
            var isSearching by remember { mutableStateOf(false) }
            BrbxTheme(theme) {
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
                    Box(modifier = Modifier.padding(paddingValues)) { }
                }
            }
        }
    }
}