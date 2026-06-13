package com.brbx.brbxdevkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import com.brbx.ui_compose.components.image.BrbxIcon
import com.brbx.ui_compose.components.searchable_top_bar.BrbxSearchableTopBar
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.mColors
import com.brbx.ui_compose.theme.mTypography
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.Arrows
import dev.chiksmedina.solar.outline.EssentionalUi
import dev.chiksmedina.solar.outline.Search
import dev.chiksmedina.solar.outline.arrows.ArrowLeft
import dev.chiksmedina.solar.outline.essentionalui.Cat
import dev.chiksmedina.solar.outline.search.Magnifer

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

            var isSearching by remember { mutableStateOf(false) }
            BrbxTheme(theme) {
                Scaffold(
                    topBar = {
                        BrbxSearchableTopBar(
                            isSearching = isSearching,
                            title = {
                                Text(
                                    text = "Title",
                                    style = mTypography.titleLarge,
                                )
                            },
                            searchIcon = {
                                IconButton(
                                    onClick = { isSearching = true }
                                ) {
                                    BrbxIcon(OutlineSolar.Search.Magnifer)
                                }
                            },
                            navigationIcon = {
                                IconButton(
                                    onClick = {}
                                ) {
                                    BrbxIcon(OutlineSolar.Arrows.ArrowLeft)
                                }
                            },
                            closeSearchIcon = {
                                IconButton(
                                    onClick = { isSearching = false }
                                ) {
                                    BrbxIcon(OutlineSolar.EssentionalUi.Cat)
                                }
                            },
                            searchField = {
                                val focusRequester = remember { FocusRequester() }
                                LaunchedEffect(Unit) { focusRequester.requestFocus() }

                                var value by remember { mutableStateOf("") }
                                val solidCursorBrush = SolidColor(mColors.primary)

                                BasicTextField(
                                    value = value,
                                    onValueChange = { value = it },
                                    modifier = Modifier
                                        .fillMaxWidth() // Растягиваем на всю доступную ширину тайтла
                                        .focusRequester(focusRequester),
                                    singleLine = true,
                                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                                    textStyle = mTypography.titleLarge.copy(
                                        color = mColors.onSurface
                                    ),
                                    cursorBrush = solidCursorBrush,
                                    decorationBox = { innerTextField ->
                                        // Box позволяет нам наложить Placeholder под текст
                                        Box(
                                            modifier = Modifier.fillMaxWidth(),
                                            contentAlignment = Alignment.CenterStart
                                        ) {
                                            if (value.isEmpty()) {
                                                Text(
                                                    text = "Search here...",
                                                    style = mTypography.bodyLarge,
                                                    color = mColors.onSurfaceVariant
                                                )
                                            }
                                            innerTextField() // Сам компонент ввода текста
                                        }
                                    }
                                )
                            }
                        )
                    },
                    modifier = Modifier
                        .fillMaxSize()
                ) { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}