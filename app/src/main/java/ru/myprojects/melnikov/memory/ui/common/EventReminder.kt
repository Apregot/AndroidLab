package ru.myprojects.melnikov.memory.ui.common

import java.util.Date

data class EventReminder(
    val title: String,
    val desc: String,
    val dateStart: Date
)