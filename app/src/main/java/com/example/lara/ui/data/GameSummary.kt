package com.example.lara.ui.data

import androidx.compose.ui.graphics.painter.Painter

data class GameSummary(
    val name: String,
    val rating: Double,
    val logo: Painter,
    val screenshots: List<Painter>,
    val ratingsQty: Int,
    val reviews: List<Review>
)

data class Review(
    val painter: Painter,
    val reviewerName: String,
    // it would be more correct to store this as date
    // and then call 'pretify' function
    // but for now it'd be easier to leave it as it is
    val publishedAt: String,
    val review: String
)