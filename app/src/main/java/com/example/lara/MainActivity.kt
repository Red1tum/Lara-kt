package com.example.lara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.lara.ui.theme.LaraTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    LaraTheme {
        ApplySystemBarColors()

        Surface(
            color = Color.Gray,
            modifier = Modifier.fillMaxSize(),
        ) {
            DotaScreen()
        }
    }
}

@Composable
fun DotaScreen() {
    val context = LocalContext.current
    val lazyListState = rememberLazyListState()
}


@Composable
fun ApplySystemBarColors() {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(color = Color.Transparent)
        systemUiController.setNavigationBarColor(color = Color.Transparent)
    }
}