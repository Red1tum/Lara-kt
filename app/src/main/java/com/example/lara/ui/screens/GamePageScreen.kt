package com.example.lara.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lara.R
import com.example.lara.ui.components.DescriptionText
import com.example.lara.ui.components.GameplayScreenshotsRow
import com.example.lara.ui.components.Header
import com.example.lara.ui.components.ReviewsAndRatingSection
import com.example.lara.ui.components.ScrollableSubgenres
import com.example.lara.data.GameSummary
import com.example.lara.data.Review
import com.example.lara.data.Screenshot
import com.example.lara.data.Video
import com.example.lara.ui.components.InstallButton

@Composable
fun GamePageScreen(viewModel: GameScreenViewModel = viewModel()) {
    //val context = LocalContext.current
    val lazyListState = rememberLazyListState()

    val summary = viewModel.getSummary()

    LazyColumn(
        state = lazyListState,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item {
            Header("Dota 2", 5.0)
        }
        item {
            ScrollableSubgenres(listOf("MOBA", "Multiplayer", "Strategy"))
        }
        item {
            DescriptionText(
                stringResource(id = R.string.dota_short_description),
                modifier = Modifier.padding(top = 9.dp)
            )
        }
        item {
            GameplayScreenshotsRow(
                screenshots = listOf(
                    Video(painterResource(id = R.drawable.dota_gameplay_screenshot_1)),
                    Screenshot(painterResource(id = R.drawable.dota_gameplay_screenshot_2)),
                    Screenshot(painterResource(id = R.drawable.dota_gameplay_screenshot_3))
                )
            )
        }
        item {
            ReviewsAndRatingSection(summary = summary)
        }
        item {
            InstallButton()
        }
    }
}

@Preview
@Composable
fun GamePageScreenPreview() {
    GamePageScreen()
}