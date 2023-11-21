package app.educaverso.commons.domain.commands

import app.educaverso.commons.domain.entities.BaseEntity

abstract class ActionCommand<T : BaseEntity<*>> : EventCommand() {
    abstract fun execute(entity: T)
}