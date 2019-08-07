package io.portsIn

import application.addToDo
import io.portsOut.EmailAdapter
import io.portsOut.TerminalAdapter
import java.time.Instant
import java.time.ZoneOffset

fun main(args: Array<String>) {
    println("Adding todo -> ${args.joinToString(" ")}")

    addToDo(args.joinToString(" "),
        Instant.now().atZone(ZoneOffset.UTC),
        listOf(TerminalAdapter(),EmailAdapter()))
}