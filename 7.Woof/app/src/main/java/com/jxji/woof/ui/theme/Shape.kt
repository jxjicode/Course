package com.jxji.woof.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(50.dp),
//    medium = RoundedCornerShape(bottomStart = 16.dp, topEnd = 16.dp),
//    medium = RoundedCornerShape(topStart = 15.dp, topEnd = 50.dp, bottomStart = 50.dp, bottomEnd = 15.dp),
    medium = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 50.dp, bottomEnd = 50.dp),
)
