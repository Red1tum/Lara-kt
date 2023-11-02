package com.example.lara.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lara.R
import com.example.lara.ui.theme.LaraTheme

@Composable
fun Logo(
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(88.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .background(
                Color.Black,
                RoundedCornerShape(14.dp)
            )
            .border(BorderStroke(2.dp, LaraTheme.BgColors.primary))
            .shadow(
                elevation = 10.dp,
                spotColor = Color.Black,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = modifier
                .fillMaxSize()
                .padding(17.dp)
        )
    }
}

@Preview
@Composable
fun LogoPreview() {
    Logo(painterResource(id = R.drawable.dota_logo))
}