package com.modernunit.traveller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.modernunit.traveller.ui.theme.TravellerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            TravellerTheme {
                Scaffold {
                    Text(
                        "Android",
                        modifier = Modifier
                            .padding(
                                WindowInsets.statusBars
                                    .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
                                    .asPaddingValues()
                            ),
                    )
                }
            }
        }
    }
}