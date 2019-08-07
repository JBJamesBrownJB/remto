package io.portsOut

import domain.ToDo

internal class TerminalAdapter : IAdapter {
    override fun Notify(todo: ToDo) {
        println(todo)
    }

}
