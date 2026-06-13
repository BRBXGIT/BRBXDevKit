package com.brbx.ui_compose.components.searchable_topbar

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.brbx.ui_compose.components.image.BrbxIcon
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bMotion
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.Arrows
import dev.chiksmedina.solar.outline.Search
import dev.chiksmedina.solar.outline.arrows.ArrowLeft
import dev.chiksmedina.solar.outline.search.Magnifer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrbxSearchableTopBar(
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    isSearching: Boolean,
    title: @Composable () -> Unit,
    searchIcon: @Composable () -> Unit,
    searchField: @Composable () -> Unit,
) {
    val enterSpatial = bMotion.enterStructuralSpec<IntOffset>()
    val exitSpatial = bMotion.exitStructuralSpec<IntOffset>()

    val alphaSpec = bMotion.nonSpatialSlowSpec<Float>(0L)

    TopAppBar(
        modifier = modifier,
        title = {
            AnimatedContent(
                targetState = isSearching,
                transitionSpec = {
                    if (!targetState) {
                        val enter = slideInHorizontally(
                            animationSpec = enterSpatial,
                            initialOffsetX = { it / 2 }
                        ) + fadeIn(animationSpec = alphaSpec)

                        val exit = slideOutHorizontally(
                            animationSpec = exitSpatial,
                            targetOffsetX = { -it / 2 }
                        ) + fadeOut(animationSpec = alphaSpec)

                        enter togetherWith exit
                    } else {
                        val enter = slideInHorizontally(
                            animationSpec = enterSpatial,
                            initialOffsetX = { -it / 2 }
                        ) + fadeIn(animationSpec = alphaSpec)

                        val exit = slideOutHorizontally(
                            animationSpec = exitSpatial,
                            targetOffsetX = { it / 2 }
                        ) + fadeOut(animationSpec = alphaSpec)

                        enter togetherWith exit
                    }
                },
                contentAlignment = Alignment.CenterStart,
                label = "SearchTransition"
            ) { searching ->
                if (searching) {
                    searchField()
                } else {
                    title()
                }
            }
        },
        navigationIcon = navigationIcon,
        actions = {
            searchIcon()
            actions()
        }
    )
}
@Preview
@Composable
private fun BrbxSearchableTopBarPreview() {
    BrbxTheme(darkColorScheme()) {
        var isSearching by remember { mutableStateOf(false) }

        BrbxSearchableTopBar(
            navigationIcon = {
                IconButton(
                    onClick = { if (isSearching) isSearching = false }
                ) {
                    BrbxIcon(OutlineSolar.Arrows.ArrowLeft)
                }
            },
            isSearching = isSearching,
            title = {
                Text(
                    text = "Title",
                )
            },
            searchIcon = {
                IconButton(
                    onClick = { isSearching = true }
                ) {
                    BrbxIcon(OutlineSolar.Search.Magnifer)
                }
            },
            searchField = {
                val focusRequester = remember { FocusRequester() }
                LaunchedEffect(Unit) { focusRequester.requestFocus() }

                var value by remember { mutableStateOf("") }
                TextField(
                    value = value,
                    onValueChange = { value = it },
                    modifier = Modifier.focusRequester(focusRequester),
                    singleLine = true,
                    placeholder = { Text(text = "Search here...") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
        )
    }
}