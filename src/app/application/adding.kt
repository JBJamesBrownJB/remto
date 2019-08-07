package application

import domain.ToDo
import domain.extractTime
import io.portsOut.IAdapter
import java.time.ZonedDateTime

fun addToDo(blurb: String, timeStamp: ZonedDateTime, adapters: List<IAdapter>) {
    adapters.forEach { p -> p.Notify(ToDo(blurb, extractTime(blurb, timeStamp))) }
}
