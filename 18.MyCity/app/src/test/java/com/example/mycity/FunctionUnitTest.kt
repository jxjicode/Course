package com.example.mycity

import com.example.mycity.data.LocalPlacesDataProvider
import org.junit.Test

import org.junit.Assert.*

class FunctionUnitTest {
    @Test
    fun getPlace_notNull() {
        val pl = LocalPlacesDataProvider.getPlacesData(1)
        println(pl)
        assertNotNull(pl)
    }
}