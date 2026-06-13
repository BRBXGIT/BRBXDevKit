package com.brbx.ui_compose.components.searchable_top_bar

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.theme.BrbxTheme

// TODO add default slot api impl
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrbxSearchableTopBar(
    modifier: Modifier = Modifier,
    appearance: BrbxSearchableTopBarAppearance = BrbxSearchableTopBarAppearances.default,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    isSearching: Boolean,
    title: @Composable () -> Unit,
    searchIcon: @Composable () -> Unit,
    closeSearchIcon: @Composable () -> Unit,
    searchField: @Composable () -> Unit,
) {
    val enterSpatial = appearance.enterSpatial()
    val exitSpatial = appearance.exitSpatial()
    val alphaSpec = appearance.alphaSpec()

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
                transitionSpec = {
                    val direction = if (targetState) -1 else 1

                    val enter = slideInHorizontally(
                        animationSpec = enterSpatial
                    ) { (it / 2) * direction } + fadeIn(animationSpec = alphaSpec)

                    val exit = slideOutHorizontally(
                        animationSpec = exitSpatial
                    ) { -(it / 2) * direction } + fadeOut(animationSpec = alphaSpec)

                    enter togetherWith exit
                },
                contentAlignment = Alignment.CenterStart,
                label = "Search field transition"
            ) { searching ->
                if (searching) searchField() else title()
            }
        },
        actions = {
            AnimatedContent(
                targetState = isSearching,
                transitionSpec = {
                    val direction = if (targetState) 1 else -1

                    val enter = slideInVertically(
                        animationSpec = enterSpatial
                    ) { (it / 2) * direction } + fadeIn(animationSpec = alphaSpec)

                    val exit = slideOutVertically(
                        animationSpec = exitSpatial
                    ) { -(it / 2) * direction } + fadeOut(animationSpec = alphaSpec)

                    enter togetherWith exit
                },
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