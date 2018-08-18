package com.mohamadk.hotelspring.utils

import java.util.*

fun Date.add(field: Int, amount: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar.add(field, amount)
    return calendar.time
}