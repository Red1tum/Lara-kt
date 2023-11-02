package com.example.lara.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lara.R
import com.example.lara.data.Content
import com.example.lara.data.Screenshot
import com.example.lara.data.Video
import com.example.lara.ui.theme.LaraTheme

@Composable
fun GameplayScreenshotsRow(
    screenshots: List<Content>,
    modifier: Modifier = Modifier
) {

    val lazyListState = rememberLazyListState()

    LazyRow(
        state = lazyListState,
        modifier = modifier.padding(start = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(screenshots) { item ->
            Box {
                Image(
                    painter = item.preview,
                    contentDescription = null,
                    modifier = modifier
                        .height(135.dp)
                        .width(240.dp)
                        .clip(RoundedCornerShape(14.dp))
                )
                if (item.isVideo()) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .background(LaraTheme.BgColors.transparentGray)
                            .clip(shape = CircleShape)
                            .size(48.dp)
                    ) {
                        Icon(
                            Icons.Rounded.PlayArrow,
                            contentDescription = "Play",
                            tint = LaraTheme.TextColors.primary,
                            modifier = Modifier
                                .size(30.dp)
                                .align(alignment = Alignment.Center)
                        )
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun GameplayScreenshotsRowPreview() {
    val screenshots = listOf(
        Video(painterResource(id = R.drawable.dota_gameplay_screenshot_1)),
        Screenshot(painterResource(id = R.drawable.dota_gameplay_screenshot_2)),
        Screenshot(painterResource(id = R.drawable.dota_gameplay_screenshot_3))
    )
    GameplayScreenshotsRow(screenshots)
}