package com.jxji.practiceclassesandcollection

import com.jxji.practiceclassesandcollection.data.Daypart
import com.jxji.practiceclassesandcollection.data.Event
import org.junit.Test

class Tasks {
    @Test
    fun task2() {
        val event = Event(
            title = "Study Kotlin",
            description = "Commit to studying Kotlin at least 15 minutes per day.",
            daypart = Daypart.EVENING,
            duration = 15
        )
        println("task2 => $event")
    }

    @Test
    fun task3() {
        val events = mutableListOf<Event>()
        events.add(
            Event(
                title = "Study Kotlin",
                description = "Commit to studying Kotlin at least 15 minutes per day.",
                daypart = Daypart.EVENING,
                duration = 15
            )
        )
        println("task3 => $events")
    }

    @Test
    fun task4() {
        val events = mutableListOf(
            Event(
                title = "Study Kotlin 1",
                description = "Commit to studying Kotlin at least 15 minutes per day.",
                daypart = Daypart.MORNING,
                duration = 15
            ),
            Event(
                title = "Study Kotlin",
                description = "Commit to studying Kotlin at least 15 minutes per day.",
                daypart = Daypart.EVENING,
                duration = 15
            ),
            Event(
                title = "Study Kotlin",
                description = "Commit to studying Kotlin at least 15 minutes per day.",
                daypart = Daypart.EVENING,
                duration = 70
            ),
        )
        val shortEvents = events.filter { it.duration < 60 }
        println("task4 => You have ${shortEvents.size} short events.")
    }

    @Test
    fun task5() {
        val events = mutableListOf(
            Event(
                title = "Study Kotlin 1",
                description = "Commit to studying Kotlin at least 15 minutes per day.",
                daypart = Daypart.MORNING,
                duration = 15
            ),
            Event(
                title = "Study Kotlin",
                description = "Commit to studying Kotlin at least 15 minutes per day.",
                daypart = Daypart.EVENING,
                duration = 15
            ),
            Event(
                title = "Study Kotlin",
                description = "Commit to studying Kotlin at least 15 minutes per day.",
                daypart = Daypart.EVENING,
                duration = 70
            ),
        )
//        val eventMap = events.groupBy { it.daypart }
//        println("task5 => Morning: ${eventMap[Daypart.MORNING]?.size?:0} events")
//        println("task5 => Afternoon: ${eventMap[Daypart.AFTERNOON]?.size?:0} events")
//        println("task5 => Evening: ${eventMap[Daypart.EVENING]?.size?:0} events")

        val groupedEvents = events.groupBy { it.daypart }
        groupedEvents.forEach { (daypart, events) ->
            println("task5 => $daypart: ${events.size} events")
        }

    }

    @Test
    fun task6() {
        val events = mutableListOf(
            Event(
                title = "Study Kotlin 1",
                description = "Commit to studying Kotlin at least 15 minutes per day.",
                daypart = Daypart.MORNING,
                duration = 15
            ),
            Event(
                title = "Study Kotlin",
                description = "Commit to studying Kotlin at least 15 minutes per day.",
                daypart = Daypart.EVENING,
                duration = 15
            ),
            Event(
                title = "LASTStudy Kotlin",
                description = "Commit to studying Kotlin at least 15 minutes per day.",
                daypart = Daypart.EVENING,
                duration = 70
            ),
        )
        println("Last event of the day: ${events.last().title}")
    }

//        fun Event.durationOfEvent(): String {
//            return if (this.duration >= 60) {
//                "long"
//            } else {
//                "short"
//            }
//        }

    val Event.durationOfEvent: String
        get() = if (this.duration < 60) {
            "short"
        } else {
            "long"
        }

    @Test
    fun task7() {
        val events = mutableListOf(
            Event(
                title = "Study Kotlin 1",
                description = "Commit to studying Kotlin at least 15 minutes per day.",
                daypart = Daypart.MORNING,
                duration = 15
            ),
            Event(
                title = "Study Kotlin",
                description = "Commit to studying Kotlin at least 15 minutes per day.",
                daypart = Daypart.EVENING,
                duration = 15
            ),
            Event(
                title = "LASTStudy Kotlin",
                description = "Commit to studying Kotlin at least 15 minutes per day.",
                daypart = Daypart.EVENING,
                duration = 70
            ),
        )

//        println("Duration of first event of the day: ${events[0].durationOfEvent()}")
        println("Duration of first event of the day: ${events[0].durationOfEvent}")
    }
}