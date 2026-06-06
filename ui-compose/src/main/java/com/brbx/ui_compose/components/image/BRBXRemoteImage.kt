package com.brbx.ui_compose.components.image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter.State
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageScope
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.brbx.ui_compose.theme.BRBXTheme
import com.brbx.ui_compose.theme.bColors

private const val DefaultCrossfadeDuration = 300

@Composable
fun BRBXRemoteImage(
    model: String?,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    filterQuality: FilterQuality = FilterQuality.Low,
    contentScale: ContentScale = ContentScale.Crop,
    crossfadeDuration: Int = DefaultCrossfadeDuration,
    onLoading: @Composable (SubcomposeAsyncImageScope.(State.Loading) -> Unit)? = null,
    onError: @Composable (SubcomposeAsyncImageScope.(State.Error) -> Unit)? = null,
) {
    val context = LocalContext.current
    val imageRequest = remember(model) {
        ImageRequest.Builder(context)
            .data(model)
            .crossfade(enable = true)
            .crossfade(durationMillis = crossfadeDuration)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .build()
    }

    SubcomposeAsyncImage(
        modifier = modifier,
        contentDescription = contentDescription,
        model = imageRequest,
        filterQuality = filterQuality,
        contentScale = contentScale,
        loading = onLoading,
        error = onError,
    )
}

@Composable
fun BRBXRemoteImage(
    model: ImageRequest?,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    filterQuality: FilterQuality = FilterQuality.Low,
    contentScale: ContentScale = ContentScale.Crop,
    onLoading: @Composable (SubcomposeAsyncImageScope.(State.Loading) -> Unit)? = null,
    onError: @Composable (SubcomposeAsyncImageScope.(State.Error) -> Unit)? = null,
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        contentDescription = contentDescription,
        model = model,
        filterQuality = filterQuality,
        contentScale = contentScale,
        loading = onLoading,
        error = onError,
    )
}

@Preview
@Composable
private fun BRBXRemoteImagePreview() {
    BRBXTheme(lightColorScheme()) {
        BRBXRemoteImage(
            modifier = Modifier.size(100.dp, 100.dp),
            model = "",
            onError = {
                Box(modifier = Modifier.fillMaxSize().background(bColors.surface))
            },
        )
    }
}