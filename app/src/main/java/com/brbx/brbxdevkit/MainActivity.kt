package com.brbx.brbxdevkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.brbx.ui_compose.containers.with_appearance.pull_to_refresh.BrbxPullToRefreshContainer
import com.brbx.ui_compose.containers.with_appearance.pull_to_refresh.BrbxPullToRefreshContainerAppearances
import com.brbx.ui_compose.theme.BrbxTheme

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


            BrbxTheme(theme) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { paddingValues ->
                    BrbxPullToRefreshContainer(
                        appearance = BrbxPullToRefreshContainerAppearances.withVibration(),
                        modifier = Modifier.padding(paddingValues),
                        isRefreshing = false,
                        onRefresh = {}
                    ) {
                        var checked by remember { mutableStateOf(false) }
                        Switch(
                            checked = checked,
                            onCheckedChange = { checked = it }
                        )

                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            items(100) {
                                Text(text = it.toString())
                            }
                        }
                    }
                }
            }
        }
    }
}