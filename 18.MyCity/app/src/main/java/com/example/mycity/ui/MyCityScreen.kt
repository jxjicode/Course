package com.example.mycity.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import com.example.mycity.data.LocalCategoriesDataProvider
import com.example.mycity.model.Category
import com.example.mycity.ui.component.CategoriesListItem

@Composable
fun MyCityScreen(
    categories: List<Category>,
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(top = 16.dp),
    ) {
        items(categories, key = { category -> category.id }) { category ->
            CategoriesListItem(
                category = category,
                onItemClick = onClick
            )
        }
    }
}

@Preview
@Composable
private fun MyCityScreenPreview() {
    MyCityScreen(
        categories = LocalCategoriesDataProvider.getCategoriesData(),
        onClick = {},
    )
}