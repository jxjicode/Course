package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Place

object LocalPlacesDataProvider {
    fun getPlacesData(categoryId: Int): List<Place> {
        val li: MutableList<Place> = mutableListOf()
        val num = (1..5).random()
        repeat(num) { idx ->
            li.add(
                Place(
                    id = categoryId * 10 + idx,
                    titleResourceId = R.string.place,
                    imageResourceId = R.drawable.place,
                )
            )
        }
        return li
    }
}