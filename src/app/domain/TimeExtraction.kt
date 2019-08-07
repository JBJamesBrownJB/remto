package domain

import java.time.DayOfWeek
import java.time.ZonedDateTime

val regex = "(tomorrow\\z)|(weekend\\z)|(next month\\z)"

internal fun extractTime(blurb: String, timeStamp: ZonedDateTime): ZonedDateTime { //todo Maybe Monad?
    return when (Regex(regex).find(blurb.toLowerCase())?.value) {
        "tomorrow" -> tomorrowMorning(timeStamp)
        "weekend" -> thisWeekend(timeStamp)
        "next month" -> nextMonth(timeStamp)
        else -> later(timeStamp)
    }
}

private fun nextMonth(timeStamp: ZonedDateTime): ZonedDateTime {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

private fun thisWeekend(timeStamp: ZonedDateTime): ZonedDateTime {
    return when(timeStamp.dayOfWeek){
        DayOfWeek.MONDAY -> timeStamp.plusDays(5)
        DayOfWeek.TUESDAY -> timeStamp.plusDays(4)
        DayOfWeek.WEDNESDAY -> timeStamp.plusDays(3)
        DayOfWeek.THURSDAY -> timeStamp.plusDays(2)
        DayOfWeek.FRIDAY -> timeStamp.plusDays(1)
        DayOfWeek.SATURDAY -> timeStamp.plusDays(7)
        DayOfWeek.SUNDAY -> timeStamp.plusDays(6)
    }
}

private fun later(timeStamp: ZonedDateTime): ZonedDateTime {
    return timeStamp.plusHours(3)
}

private fun tomorrowMorning(timeStamp: ZonedDateTime): ZonedDateTime {
    return timeStamp
        .plusDays(1)
        .withHour(10)
        .withMinute(0)
        .withSecond(0)
}