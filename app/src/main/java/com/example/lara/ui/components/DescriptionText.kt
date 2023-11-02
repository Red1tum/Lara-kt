package com.example.lara.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lara.R
import com.example.lara.ui.theme.LaraTheme

@Composable
fun DescriptionText(
    description: String,
    modifier: Modifier = Modifier
) {

    Text(
        text = description,
        modifier = modifier.padding(horizontal = 21.dp),
        style = LaraTheme.TextStyle.Regular_12_19,
        color = LaraTheme.TextColors.secondary
    )
}

@Preview
@Composable
fun DescriptionTextPreview() {
    DescriptionText(stringResource(id = R.string.dota_short_description))
}