package app.educaverso.commons.domain.entities

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.commons.domain.commands.CreateCommand
import app.educaverso.commons.domain.value.objects.BaseId

abstract class BaseEntity<Id : BaseId<*>>(val id: Id) {

    companion object {
        fun <T> execute(command: CreateCommand<T>): T where T : BaseEntity<*> {
            return command.execute()
        }
    }

    open fun <T> execute(actionCommand: ActionCommand<T>) where T : BaseEntity<*> {
        actionCommand.execute(this as T)
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