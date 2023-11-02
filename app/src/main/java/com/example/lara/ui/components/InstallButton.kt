package com.example.lara.ui.components

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lara.ui.theme.LaraTheme

@Composable
fun InstallButton(
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(0.dp, 64.dp)
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = LaraTheme.ButtonColors.installColor),
        onClick = { /*TODO*/ },
    ) {
        Text(
            text = "Install",
            style = LaraTheme.TextStyle.Bold_20_24,
            color = LaraTheme.TextColors.black,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun InstallButtonPreview() {
    InstallButton()
}