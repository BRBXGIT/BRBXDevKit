package com.brbx.ui_compose.components.complex.searchable_top_bar

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.common.BrbxText
import com.brbx.ui_compose.common.asString
import com.brbx.ui_compose.theme.BrbxTheme

/**
 * An interactive Top App Bar that seamlessly transitions between a standard title state
 * and a search input state.
 *
 * This variant uses the Slot API, allowing completely custom composables for the title
 * and the search field. It handles the transition animations defined by the [appearance].
 *
 * @param modifier The [Modifier] applied to the top app bar.
 * @param appearance The visual and structural configuration of the top bar.
 * @param scrollBehavior An optional [TopAppBarScrollBehavior] to respond to scroll events.
 * @param navigationIcon A slot for the primary navigation icon (e.g., a back button).
 * @param actions Additional action icons placed at the end of the top bar.
 * @param isSearching Indicates the current state. When `true`, the search field is displayed.
 * @param onSystemBackClick Callback invoked when the system back button is pressed while searching.
 * @param title The composable slot representing the default top bar title.
 * @param searchIcon The composable slot for the icon that initiates the search.
 * @param closeSearchIcon The composable slot for the icon that cancels the search or clears input.
 * @param searchField The composable slot containing the actual search input field.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrbxSearchableTopBar(
    modifier: Modifier = Modifier,
    appearance: BrbxSearchableTopBarAppearance = BrbxSearchableTopBarAppearances.default,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    isSearching: Boolean,
    onSystemBackClick: () -> Unit,
    title: @Composable () -> Unit,
    searchIcon: @Composable () -> Unit,
    closeSearchIcon: @Composable () -> Unit,
    searchField: @Composable () -> Unit,
) =
    BrbxSearchableTopBarImpl(
        modifier = modifier,
        appearance = appearance,
        scrollBehavior = scrollBehavior,
        navigationIcon = navigationIcon,
        actions = actions,
        isSearching = isSearching,
        onSystemBackClick = onSystemBackClick,
        title = title,
        searchIcon = searchIcon,
        closeSearchIcon = closeSearchIcon,
        searchField = searchField,
    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrbxSearchableTopBar(
    modifier: Modifier = Modifier,
    appearance: BrbxSearchableTopBarAppearance = BrbxSearchableTopBarAppearances.default,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    isSearching: Boolean,
    onSystemBackClick: () -> Unit,
    title: BrbxText,
    searchIcon: @Composable () -> Unit,
    closeSearchIcon: @Composable () -> Unit,
    searchFieldPlaceholderText: BrbxText,
    textFieldValue: () -> String,
    onTextFieldValueChange: (String) -> Unit,
) {
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = isSearching) {
        if (isSearching) {
            focusRequester.requestFocus()
        } else {
            focusRequester.freeFocus()
            keyboardController?.hide()
        }
    }

    val currentOnSystemBackClick by rememberUpdatedState(newValue = onSystemBackClick)
    val currentKeyboardController by rememberUpdatedState(newValue = keyboardController)
    val handleSystemBackClick = remember(key1 = focusRequester) {
        {
            focusRequester.freeFocus()
            currentOnSystemBackClick()
            currentKeyboardController?.hide()!!
        }
    }
    BrbxSearchableTopBarImpl(
        modifier = modifier,
        appearance = appearance,
        scrollBehavior = scrollBehavior,
        navigationIcon = navigationIcon,
        actions = actions,
        isSearching = isSearching,
        onSystemBackClick = handleSystemBackClick,
        title = {
            Text(
                text = title.asString(),
                style = appearance.defaultTitleStyle(),
            )
        },
        searchIcon = searchIcon,
        closeSearchIcon = closeSearchIcon,
        searchField = {
            DefaultSearchField(
                textFieldValue = textFieldValue,
                onTextFieldValueChange = onTextFieldValueChange,
                focusRequester = focusRequester,
                appearance = appearance,
                searchFieldPlaceholderText = searchFieldPlaceholderText,
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BrbxSearchableTopBarImpl(
    modifier: Modifier,
    appearance: BrbxSearchableTopBarAppearance,
    scrollBehavior: TopAppBarScrollBehavior?,
    isSearching: Boolean,
    onSystemBackClick: () -> Unit,
    navigationIcon: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    title: @Composable () -> Unit,
    searchIcon: @Composable () -> Unit,
    closeSearchIcon: @Composable () -> Unit,
    searchField: @Composable () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        expandedHeight = appearance.expandedHeight(),
        windowInsets = appearance.windowInsets(),
        colors = appearance.colors(),
        scrollBehavior = scrollBehavior,
        navigationIcon = navigationIcon,
        contentPadding = appearance.contentPadding(),
        title = {
            AnimatedContent(
                targetState = isSearching,
                transitionSpec = appearance.searchFieldTransitionSpec(),
                contentAlignment = Alignment.CenterStart,
                label = "Search field transition"
            ) { searching ->
                if (searching) {
                    BackHandler(
                        enabled = isSearching,
                        onBack = onSystemBackClick,
                    )
                    searchField()
                } else title()
            }
        },
        actions = {
            AnimatedContent(
                targetState = isSearching,
                transitionSpec = appearance.searchIconTransitionSpec(),
                contentAlignment = Alignment.Center,
                label = "Search icon transition"
            ) { searching ->
                if (searching) closeSearchIcon() else searchIcon()
            }

            actions()
        }
    )
}

@Composable
private fun DefaultSearchField(
    textFieldValue: () -> String,
    onTextFieldValueChange: (String) -> Unit,
    focusRequester: FocusRequester,
    appearance: BrbxSearchableTopBarAppearance,
    searchFieldPlaceholderText: BrbxText,
) {
    var textWidth by remember { mutableIntStateOf(value = 0) }
    var containerWidth by remember { mutableIntStateOf(value = 0) }
    val isOverflowing by remember { derivedStateOf { textWidth > containerWidth } }

    val fadeProgress by animateFloatAsState(
        targetValue = if (isOverflowing) 1f else 0f,
        animationSpec = tween(durationMillis = 150, easing = LinearEasing),
        label = "Text overflow fade animation"
    )

    val value = textFieldValue()
    BasicTextField(
        value = value,
        onValueChange = onTextFieldValueChange,
        onTextLayout = { textLayoutResult ->
            textWidth = textLayoutResult.size.width
        },
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .onGloballyPositioned { coordinates ->
                containerWidth = coordinates.size.width
            },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        textStyle = appearance.defaultSearchFieldTextStyle(),
        cursorBrush = appearance.defaultSearchFieldCursorBrush(),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = searchFieldPlaceholderText.asString(),
                        style = appearance.defaultSearchFieldPlaceholderStyle(),
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer {
                            compositingStrategy = if (fadeProgress > 0f) {
                                CompositingStrategy.Offscreen
                            } else {
                                CompositingStrategy.Auto
                            }
                        }
                        .drawWithContent {
                            drawContent()
                            if (fadeProgress > 0f) {
                                drawRect(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            Color.Black.copy(alpha = 1f - fadeProgress),
                                            Color.Black
                                        ),
                                        startX = 0f,
                                        endX = 32.dp.toPx()
                                    ),
                                    blendMode = BlendMode.DstIn
                                )
                            }
                        }
                ) {
                    innerTextField()
                }
            }
        },
    )
}

@Preview
@Composable
private fun BrbxSearchableTopBarPreview() {
    BrbxTheme(darkColorScheme()) {

    }
}