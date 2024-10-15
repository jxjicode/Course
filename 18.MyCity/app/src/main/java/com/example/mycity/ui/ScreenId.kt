package com.example.mycity.ui

import androidx.annotation.StringRes
import com.example.mycity.R

enum class ScreenId(@StringRes val title: Int) {
    MyCity(title = R.string.app_name),
    Category(title = R.string.category),
    Place(title = R.string.place)
}