package com.brbx.brbxdevkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brbx.brbxdevkit.ui.theme.BRBXDevKitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BRBXDevKitTheme {
                DELETE()
            }
        }
    }
}

@Composable
fun DELETE(modifier: Modifier = Modifier) {

}