package com.jxji.practiceclassesandcollection.data

data class Event(
    var title: String,
    var description: String? = null,
    var daypart: Daypart,
    var duration: Int
)
