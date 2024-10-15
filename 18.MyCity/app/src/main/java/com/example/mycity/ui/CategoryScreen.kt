package com.example.mycity.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.LocalPlacesDataProvider
import com.example.mycity.model.Place
import com.example.mycity.ui.component.PlacesListItem

@Composable
fun CategoryScreen(
    places: List<Place>,
    onClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(top = 16.dp),
    ) {
        items(places, key = { place -> place.id }) { place ->
            PlacesListItem(
                place = place,
                onItemClick = onClick
            )
        }
    }
}

@Preview
@Composable
private fun CategoryScreenPreview() {
    CategoryScreen(
        places = LocalPlacesDataProvider.getPlacesData(1),
        onClick = {}
    )
}