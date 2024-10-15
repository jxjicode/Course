package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R

@Composable
fun PlaceScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.place_room),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Text(
            text = "Details of the place\nHas great coffee and\nDonuts. Also try out the\nGinger scones.\nOffer dog friendly outdoor\npatio.",
            style = MaterialTheme.typography.bodyLarge
        )

    }
}

@Preview
@Composable
private fun PlaceScreenPreview() {
    PlaceScreen()
}