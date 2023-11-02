package com.example.lara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import com.example.lara.ui.components.Header
import com.example.lara.ui.components.ScrollableSubgenres
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
            color = LaraTheme.BgColors.primary,
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

    LazyColumn(
        state = lazyListState
    ) {
        item {
            Header("Dota 2", 5.0)
        }
        item {
            ScrollableSubgenres(listOf("MOBA", "Multiplayer", "Strategy"))
        }
    }
}

@Composable
fun ApplySystemBarColors() {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(color = Color.Transparent)
        systemUiController.setNavigationBarColor(color = Color.Transparent)
    }
}