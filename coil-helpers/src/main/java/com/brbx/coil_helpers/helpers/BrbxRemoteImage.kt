package com.brbx.coil_helpers.helpers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter.State
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageScope
import coil.request.CachePolicy
import coil.request.ImageRequest

/**
 * Renders a remote image using a pre-configured [ImageRequest].
 *
 * @param model The [ImageRequest] configuration.
 * @param modifier The modifier to be applied to the layout.
 * @param contentDescription Text used by accessibility services.
 * @param filterQuality The [FilterQuality] for bitmap scaling.
 * @param contentScale Defines how the image should be scaled to fit its bounds.
 * @param onLoading Composable content to display while the image is loading.
 * @param onError Composable content to display if the image request fails.
 */
@Composable
fun BrbxRemoteImage(
    model: ImageRequest?,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    filterQuality: FilterQuality = FilterQuality.Low,
    contentScale: ContentScale = ContentScale.Crop,
    onLoading: @Composable (SubcomposeAsyncImageScope.(State.Loading) -> Unit)? = null,
    onError: @Composable (SubcomposeAsyncImageScope.(State.Error) -> Unit)? = null,
) {
    SubcomposeAsyncImage(
        model = model,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale,
        filterQuality = filterQuality,
        loading = onLoading,
        error = onError,
    )
}

/**
 * Renders a remote image from a URL [String].
 *
 * This overload automatically constructs an [ImageRequest] with default
 * caching policies (disk and memory) and a crossfade animation.
 *
 * @param model The image URL string.
 * @param modifier The modifier to be applied to the layout.
 * @param contentDescription Text used by accessibility services.
 * @param filterQuality The [FilterQuality] for bitmap scaling.
 * @param contentScale Defines how the image should be scaled to fit its bounds.
 * @param crossfadeDuration The duration of the crossfade animation in milliseconds.
 * @param onLoading Composable content to display while the image is loading.
 * @param onError Composable content to display if the image request fails.
 */
@Composable
fun BrbxRemoteImage(
    model: String?,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    filterQuality: FilterQuality = FilterQuality.Low,
    contentScale: ContentScale = ContentScale.Crop,
    crossfadeDuration: Int = 300,
    onLoading: @Composable (SubcomposeAsyncImageScope.(State.Loading) -> Unit)? = null,
    onError: @Composable (SubcomposeAsyncImageScope.(State.Error) -> Unit)? = null,
) {
    val context = LocalContext.current
    val imageRequest = remember(key1 = model) {
        ImageRequest.Builder(context)
            .data(model)
            .crossfade(enable = true)
            .crossfade(durationMillis = crossfadeDuration)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .build()
    }

    BrbxRemoteImage(
        model = imageRequest,
        modifier = modifier,
        contentDescription = contentDescription,
        filterQuality = filterQuality,
        contentScale = contentScale,
        onLoading = onLoading,
        onError = onError,
    )
}