package com.example.lara.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lara.ui.theme.LaraTheme

@Composable
fun ScrollableSubgenres(
    subgenres: List<String>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(start = 24.dp, end = 24.dp)
) {
    val lazylistState = rememberLazyListState()
    LazyRow(
        state = lazylistState,
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(subgenres) { item ->
            Subgenre(name = item)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Subgenre(name: String, modifier: Modifier = Modifier) {
    SuggestionChip(
        label = { Text(text = name, fontSize = 10.sp) },
        modifier = modifier.padding(start = 4.dp, end = 4.dp),
        onClick = {},
        shape = RoundedCornerShape(size = 100.dp),
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor =  Color(0x3D44A9F4),
            labelColor = LaraTheme.BgColors.subgenres
        )
    )
}

@Preview
@Composable
fun SubgenrePreview() {
    Subgenre(name = "MOBA")
}

@Preview
@Composable
fun ScrollableSubgenresPreview() {
    val subgenres = listOf("MOBA", "Multiplayer", "Strategy", "Test", "More test")
    ScrollableSubgenres(subgenres = subgenres)
}