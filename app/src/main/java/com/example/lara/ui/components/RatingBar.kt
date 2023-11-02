package com.example.lara.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lara.R
import com.example.lara.ui.theme.LaraTheme
import kotlin.math.floor
import kotlin.math.round

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    maxStars: Int = 5,
) {
    val filledStars = floor(rating).toInt()
    val halfStar = round(rating) > filledStars
    val unfilledStars = (maxStars - round(rating)).toInt()

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(filledStars) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = LaraTheme.BgColors.star,
                modifier = modifier.size(12.dp)
            )
        }

        if (halfStar) {
            Icon(
                painter = painterResource(id = R.drawable.star_half),
                contentDescription = null,
                tint = LaraTheme.BgColors.star,
                modifier = modifier.size(12.dp)
            )
        }

        repeat(unfilledStars) {
            Icon(
                painter = painterResource(id = R.drawable.star_outline),
                contentDescription = null,
                tint = LaraTheme.BgColors.star,
                modifier = modifier.size(12.dp)
            )
        }
    }
}

@Preview
@Composable
fun RatingBarPreview() {
    RatingBar(rating = 4.51)
}