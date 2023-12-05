package app.educaverso.commons.domain.commands

import app.educaverso.commons.domain.entities.BaseEntity
import app.educaverso.commons.domain.events.Event

interface ActionCommand<T : BaseEntity<*>, E : Event> {
    fun execute(entity: T): E
}