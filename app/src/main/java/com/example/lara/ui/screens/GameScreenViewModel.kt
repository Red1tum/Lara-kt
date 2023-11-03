package com.example.lara.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.example.lara.R
import com.example.lara.data.GameSummary
import com.example.lara.data.Review
import com.example.lara.data.Screenshot
import com.example.lara.data.Video

class GameScreenViewModel : ViewModel() {
    private var _summary: GameSummary? = null

    @Composable
    fun getSummary(): GameSummary {
        if (_summary != null) {
            return _summary as GameSummary
        }

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

        _summary = GameSummary(
            name = "Dota 2",
            rating = 5.0,
            ratingsQty = "70M",
            reviews = reviews,
            logo = painterResource(id = R.drawable.dota_logo),
            screenshots = listOf(
                Video(painterResource(id = R.drawable.dota_gameplay_screenshot_1)),
                Screenshot(painterResource(id = R.drawable.dota_gameplay_screenshot_2)),
                Screenshot(painterResource(id = R.drawable.dota_gameplay_screenshot_3))
            ),
            subgenres = listOf("MOBA", "Multiplayer", "Strategy"),
            shortDescription = stringResource(id = R.string.dota_short_description)
        )

        return _summary as GameSummary
    }
}