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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brbx.brbxdevkit.ui.theme.BRBXDevKitTheme
import com.brbx.ui_compose.common.toBRBXIcon
import com.brbx.ui_compose.components.with_appearance.precollection.BRBXPrecollection
import com.brbx.ui_compose.components.with_appearance.tile.BRBXTile
import com.brbx.ui_compose.components.with_appearance.tile.appearance.BRBXTileAppearances
import com.brbx.ui_compose.containers.with_appearance.image.appearance.BRBXIconContainerAppearances
import com.brbx.ui_compose.containers.with_appearance.image.appearance.rememberCopy
import com.brbx.ui_compose.theme.BRBXTheme
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mTypography
import dev.chiksmedina.solar.BoldSolar
import dev.chiksmedina.solar.bold.Call
import dev.chiksmedina.solar.bold.call.CallDropped

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
            BRBXTheme(theme) {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { padding ->
                    Column(
                        verticalArrangement = Arrangement.spacedBy(bDimens.dp16),
                        modifier = Modifier.padding(padding)
                    ) {
                        BRBXTile(
                            appearance = BRBXTileAppearances.elevated,
                            iconContainerAppearance = BRBXIconContainerAppearances.withBadge,
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                            icon = BoldSolar.Call.CallDropped.toBRBXIcon(),
                            title = "Call dropped",
                            description = "The call was dropped by the outgoing",
                            onClick = {  },
                            badgeContent = {
                                Text(
                                    text = "3",
                                    style = mTypography.labelSmall
                                )
                            },
                            additionalContent = {
                                BRBXPrecollection(
                                    text = "You can add additional content here",
                                    modifier = Modifier.fillMaxWidth(),
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}