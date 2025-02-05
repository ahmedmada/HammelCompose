package com.qader.hammelcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.qader.hammelcompose.search.SearchScreen
import com.qader.hammelcompose.ui.theme.HammelComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HammelComposeTheme {
                SearchScreen()
            }
        }
    }
}


