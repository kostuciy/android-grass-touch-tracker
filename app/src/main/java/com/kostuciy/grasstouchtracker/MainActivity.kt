package com.kostuciy.grasstouchtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kostuciy.ui.theme.GrassTouchTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GrassTouchTrackerTheme {
//                ! TODO: link Koin to current Compose application
            }
        }
    }
}
