package com.example.lara.data

import androidx.compose.ui.graphics.painter.Painter

data class GameSummary(
    val name: String,
    val rating: Double,
    val logo: Painter,
    val screenshots: List<Content>,
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

// this interface needed to differentiate video from screenshot
// so we understand when to draw play button
interface Content {
    val preview: Painter
    fun isVideo(): Boolean
}

class Screenshot(override val preview: Painter) : Content {
    override fun isVideo(): Boolean {
        return false
    }
}

class Video(override val preview: Painter) : Content {
    override fun isVideo(): Boolean {
        return true
    }
}