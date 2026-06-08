package com.brbx.brbxdevkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.common.toBrbxIcon
import com.brbx.ui_compose.components.with_appearance.tile.shimmer.BRBXTileShimmer
import com.brbx.ui_compose.components.with_appearance.tile.tile.BrbxTile
import com.brbx.ui_compose.containers.scaffold.BrbxShimmerScaffold
import com.brbx.ui_compose.containers.with_appearance.image.image.BrbxIconContainerAppearances
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.mTypography
import dev.chiksmedina.solar.BoldSolar
import dev.chiksmedina.solar.bold.Call
import dev.chiksmedina.solar.bold.call.CallDropped
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

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

            var isShimmering by remember { mutableStateOf(true) }
            LaunchedEffect(isShimmering) {
                delay(5000.milliseconds)
                isShimmering = !isShimmering
            }


            BrbxTheme(theme) {
                BrbxShimmerScaffold(
                    isShimmering = isShimmering,
                    modifier = Modifier.fillMaxSize(),
                    shimmerContent = { paddingValues ->
                        Column(
                            verticalArrangement = Arrangement.spacedBy(bDimens.dp16),
                            modifier = Modifier.padding(paddingValues)
                        ) {
                            BRBXTileShimmer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp)
                            )

                            BRBXTileShimmer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp)
                            )
                        }
                    },
                    content = { paddingValues ->
                        Column(
                            verticalArrangement = Arrangement.spacedBy(bDimens.dp16),
                            modifier = Modifier.padding(paddingValues)
                        ) {
                            BrbxTile(
                                iconContainerAppearance = BrbxIconContainerAppearances.withBadge,
                                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                                icon = BoldSolar.Call.CallDropped.toBrbxIcon(),
                                title = "Call dropped",
                                description = "The call was dropped by the outgoing",
                                onClick = {  },
                                badgeContent = {
                                    Text(
                                        text = "3",
                                        style = mTypography.labelSmall
                                    )
                                },
                            )

                            BrbxTile(
                                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                                icon = BoldSolar.Call.CallDropped.toBrbxIcon(),
                                title = "Call dropped",
                                description = "The call was dropped by the outgoing",
                                onClick = {  },
                            )
                        }
                    }
                )
            }
        }
    }
}