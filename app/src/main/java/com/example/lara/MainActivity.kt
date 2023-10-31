package com.example.lara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.lara.ui.theme.LaraTheme
import com.example.lara.ui.theme.Purple80
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    LaraTheme {
        ApplySystemBarColors()

        Surface(
            color = Color.Gray,
            modifier = Modifier.fillMaxSize(),
        ) {
            DotaScreen()
        }
    }
}

@Composable
fun DotaScreen() {
    val context = LocalContext.current
    val lazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyListState
    ) {
        item {
            DotaScreenHeader()
        }
    }
}

@Composable
fun DotaScreenHeader(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.dota_top),
            contentDescription = "header",
        )
        Row(
            modifier = modifier.padding(top = 112.dp, start = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.dota_logo),
                contentDescription = null,
                modifier = modifier.border(BorderStroke(1.dp, Color.Gray))
            )
            Spacer(Modifier.padding(start = 8.dp))
            Column(
                //modifier = modifier.padding(bottom = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Dota 2",
                    fontSize = 8.sp,
                    color = Color.Red,
                    //modifier = modifier.padding(bottom = 1.dp),
                )
                Row()
                {
                    RatingBar(rating = 4.0)
                    Text(
                        text = "70M",
                        fontSize = 4.sp,
                        color = Color.Red,
                        modifier = modifier.padding(start = 3.dp)
                    )
                }
            }

        }

    }
}

@Composable
fun ScrollableSubgenres(
    subgenres: List<String>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(start = 24.dp, end = 24.dp)
) {
    LazyRow(
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
        label = { Text(text = name) },
        onClick = {},
        shape = RoundedCornerShape(16.dp),
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor =  Purple80
        )
    )
}

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    maxStars: Int = 5,
) {
    val filledStars = floor(rating).toInt()
    val halfStar = round(rating) > filledStars
    val unfilledStars = (maxStars - round(rating)).toInt()

    Row(modifier = modifier) {
        repeat(filledStars) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = Color.Yellow,
                modifier = modifier.size(5.dp)
            )
        }

        if (halfStar) {
            Icon(
                painter = painterResource(id = R.drawable.star_half),
                contentDescription = null,
                tint = Color.Yellow,
                modifier = modifier.size(5.dp)
            )
        }

        repeat(unfilledStars) {
            Icon(
                painter = painterResource(id = R.drawable.star_outline),
                contentDescription = null,
                tint = Color.Yellow,
                modifier = modifier.size(5.dp)
            )
        }
    }
}

@Composable
fun ScrollAwareHeader(

) {

}


@Composable
fun ApplySystemBarColors() {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(color = Color.Transparent)
        systemUiController.setNavigationBarColor(color = Color.Transparent)
    }
}

@Preview
@Composable
fun DotaHeaderPreview() {
    Surface(
        color = Color.Gray,
    ) {
        DotaScreenHeader()
    }
}

@Preview
@Composable
fun RatingBarPreview() {
    RatingBar(rating = 4.51)
}

//@Preview
//@Composable
//fun DotaScreenPreview() {
//    DotaScreen()
//}

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