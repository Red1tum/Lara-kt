package com.example.lara.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lara.R
import com.example.lara.ui.components.DescriptionText
import com.example.lara.ui.components.GameplayScreenshotsRow
import com.example.lara.ui.components.Header
import com.example.lara.ui.components.ReviewsAndRatingSection
import com.example.lara.ui.components.ScrollableSubgenres
import com.example.lara.ui.data.GameSummary
import com.example.lara.ui.data.Review

@Composable
fun GamePageScreen() {
    //val context = LocalContext.current
    val lazyListState = rememberLazyListState()

    val reviews = listOf(
        Review(
            painter = painterResource(id = R.drawable.avatar_1),
            reviewerName = "Auguste Conte",
            publishedAt = "February 14, 2019",
            review = "Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers."
        ),
        Review(
            painter = painterResource(id = R.drawable.avatar_2),
            reviewerName = "Jang Marcelino",
            publishedAt = "February 14, 2019",
            review = "Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers."
        ),
    )

    val summary = GameSummary(
        name = "Dota 2",
        rating = 5.0,
        ratingsQty = 70,
        reviews = reviews,
        logo = painterResource(id = R.drawable.dota_logo),
        screenshots = listOf(),
    )

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
            GameplayScreenshotsRow(screenshots = listOf(
                painterResource(id = R.drawable.dota_gameplay_screenshot_1),
                painterResource(id = R.drawable.dota_gameplay_screenshot_2),
                painterResource(id = R.drawable.dota_gameplay_screenshot_3)
            ))
        }
        item {
            ReviewsAndRatingSection(summary = summary)
        }
    }
}

@Preview
@Composable
fun GamePageScreenPreview() {
    GamePageScreen()
}