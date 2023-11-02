package com.example.lara.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lara.R

@Composable
fun GameplayScreenshotsRow(
    screenshots: List<Painter>,
    modifier: Modifier = Modifier
) {

    val lazyListState = rememberLazyListState()

    LazyRow(
        state = lazyListState,
        modifier = modifier.padding(start = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(screenshots) {item ->
            Image(
                painter = item,
                contentDescription = null,
                modifier = modifier
                    .height(135.dp)
                    .width(240.dp)
                    .clip(RoundedCornerShape(14.dp)),

            )
        }
    }
}

@Preview
@Composable
fun GameplayScreenshotsRowPreview() {
    val screenshots = listOf(
        painterResource(id = R.drawable.dota_gameplay_screenshot_1),
        painterResource(id = R.drawable.dota_gameplay_screenshot_2),
        painterResource(id = R.drawable.dota_gameplay_screenshot_3)
    )
    GameplayScreenshotsRow(screenshots)
}