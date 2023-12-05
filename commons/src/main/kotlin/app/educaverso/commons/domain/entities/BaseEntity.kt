package app.educaverso.commons.domain.entities

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.commons.domain.events.Event
import app.educaverso.commons.domain.values.BaseId

abstract class BaseEntity<Id : BaseId<*>>(val id: Id) {

    open fun <T : BaseEntity<Id>, E : Event> execute(actionCommand: ActionCommand<T, E>): E {
        val command = this as T
        return actionCommand.execute(command)
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BaseEntity<*>) return false
        return id == other.id
    }

}