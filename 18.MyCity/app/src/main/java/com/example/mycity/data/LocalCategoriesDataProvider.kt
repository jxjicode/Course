package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Category

object LocalCategoriesDataProvider {
    val defaultCategory = getCategoriesData()[0]

    fun getCategoriesData(): List<Category> {
        return listOf(
            Category(
                id = 1,
                titleResourceId = R.string.category,
                imageResourceId = R.drawable.category,
            ),
            Category(
                id = 2,
                titleResourceId = R.string.category,
                imageResourceId = R.drawable.category,
            ),
            Category(
                id = 3,
                titleResourceId = R.string.category,
                imageResourceId = R.drawable.category,
            ),
            Category(
                id = 4,
                titleResourceId = R.string.category,
                imageResourceId = R.drawable.category,
            ),
            Category(
                id = 5,
                titleResourceId = R.string.category,
                imageResourceId = R.drawable.category,
            ),
        )
    }
}