package com.example.lara.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lara.R
import com.example.lara.ui.theme.LaraTheme

@Composable
fun Header(
    name: String,
    rating: Double,
    ratingsQty: String,
    modifier: Modifier = Modifier
) {
    Box(
        // don't like that i have to manually set this
        // but passing modifier parameter doesn't seem to work
        modifier = modifier
            .height(405.dp)
            .fillMaxWidth()
    ) {

        Image(
            painter = painterResource(R.drawable.dota_top),
            contentDescription = "header",
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter,
            modifier = modifier
                .height(370.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(bottomEnd = 50.dp, bottomStart = 50.dp))
        )
        val brush = Brush.verticalGradient(listOf(Color.Black, Color.Transparent))
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            onDraw ={ drawRect(brush) }
        )

        Row(
            modifier = modifier
                .align(alignment = Alignment.BottomStart)
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Logo(painterResource(id = R.drawable.dota_logo))
            Column(
                modifier = modifier.padding(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = name,
                    style = LaraTheme.TextStyle.Bold_20,
                    color = LaraTheme.TextColors.primary,
                )
                Row()
                {
                    RatingBar(rating = rating)
                    Text(
                        text = ratingsQty,
                        style = LaraTheme.TextStyle.Regular_12_14,
                        color = LaraTheme.TextColors.dark,
                        modifier = modifier.padding(start = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HeaderPreview() {
    Header("Dota 2", 5.0, "70M")
}