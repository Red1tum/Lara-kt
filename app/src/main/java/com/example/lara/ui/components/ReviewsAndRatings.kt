package com.example.lara.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lara.R
import com.example.lara.ui.data.GameSummary
import com.example.lara.ui.data.Review
import com.example.lara.ui.theme.LaraTheme



@Composable
fun ReviewCard(
    review: Review,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Row(
            modifier = modifier.padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = review.painter,
                modifier = modifier
                    .size(36.dp)
                    .clip(CircleShape),
                contentDescription = null
            )
            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                Text(
                    text = review.reviewerName,
                    style = LaraTheme.TextStyle.Bold_16_19,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
                Text(
                    text = review.publishedAt,
                    style = LaraTheme.TextStyle.Regular_12_14,
                    color = Color.White.copy(alpha = 0.4f)
                )
            }
        }
        Text(
            text = review.review,
            style = LaraTheme.TextStyle.Regular_12_20,
            color = Color(0xffa8adb7),
            modifier = modifier.padding(horizontal = 24.dp)
        )
    }

}

@Composable
fun ReviewsColumn(
    reviews: List<Review>,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(50.dp),
        modifier = modifier
    ) {
        reviews.forEachIndexed { idx, item ->
            ReviewCard(review = item)
            if (idx < reviews.size) {
                Divider(
                    modifier = modifier
                        .border(width = 1.dp, color = Color(0xFF1A1F29))
                        .width(300.dp)
                )
            }
        }
    }
}

@Composable
fun ReviewsAndRatingsHeader(
    gameRating: Double,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal= 24.dp)
    ) {
        Text(
            text = stringResource(id = R.string.reviews_and_ratings),
            style = LaraTheme.TextStyle.Bold_16_19,
            color = Color.White
        )
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = gameRating.toString(),
                style = LaraTheme.TextStyle.Bold_48_57,
                color = Color.White
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                RatingBar(rating = gameRating)
                Text(
                    //TODO: add localization to reviews
                    text = "70M Reviews",
                    style = LaraTheme.TextStyle.Regular_12_14,
                    color = Color(0xFFA8ADB7)
                )
            }
        }
    }
}

@Composable
fun ReviewsAndRatingSection(
    summary: GameSummary,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(33.dp)
    ) {
        ReviewsAndRatingsHeader(gameRating = summary.rating)
        ReviewsColumn(summary.reviews)
    }

}

@Preview
@Composable
fun ReviewsAndRatingsHeaderPreview() {
    ReviewsAndRatingsHeader(gameRating = 5.0)
}

@Preview
@Composable
fun ReviewsAndRatingSectionPreview() {
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

    ReviewsAndRatingSection(summary = summary)
}

