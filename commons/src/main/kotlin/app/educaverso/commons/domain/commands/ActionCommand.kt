package app.educaverso.commons.domain.commands

import app.educaverso.commons.domain.entities.BaseEntity
import app.educaverso.commons.domain.events.Event

abstract class ActionCommand<T : BaseEntity<*>, E : Event> : EventDispatcherCommand<E>() {
    abstract fun execute(entity: T)
}