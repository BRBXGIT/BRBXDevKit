package com.brbx.ui_compose.components.searchable_top_bar

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.core.common.BrbxText
import com.brbx.ui_compose.components.text.BrbxText
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
    textFieldValue: String,
    onTextFieldValueChange: (String) -> Unit,
) {
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(key1 = isSearching) { focusRequester.requestFocus() }
    BrbxSearchableTopBarImpl(
        modifier = modifier,
        appearance = appearance,
        scrollBehavior = scrollBehavior,
        navigationIcon = navigationIcon,
        actions = actions,
        isSearching = isSearching,
        onSystemBackClick = {
            focusRequester.freeFocus()
            onSystemBackClick()
        },
        title = {
            BrbxText(
                text = title,
                style = appearance.titleStyle(),
            )
        },
        searchIcon = searchIcon,
        closeSearchIcon = closeSearchIcon,
        searchField = {
            BasicTextField(
                value = textFieldValue,
                onValueChange = onTextFieldValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                textStyle = appearance.searchFieldTextStyle(),
                cursorBrush = appearance.searchFieldCursorBrush(),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (textFieldValue.isEmpty()) {
                            BrbxText(
                                text = searchFieldPlaceholderText,
                                style = appearance.searchFieldPlaceholderStyle(),
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }
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
                        onBack = onSystemBackClick
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

@Preview
@Composable
private fun BrbxSearchableTopBarPreview() {
    BrbxTheme(darkColorScheme()) {

    }
}