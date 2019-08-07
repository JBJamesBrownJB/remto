package io.portsOut

import domain.ToDo

interface IAdapter {
    fun Notify(todo:ToDo)
}