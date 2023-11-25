package app.educaverso.commons.domain.commands

import app.educaverso.commons.domain.entities.BaseEntity
import app.educaverso.commons.domain.events.Event

abstract class FactoryMethodCommand<T : BaseEntity<*>, E : Event> : EventCommand<E>() {
    abstract fun execute(): T
}