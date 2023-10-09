package app.educaverso.commons.domain.commands

import app.educaverso.commons.domain.entities.BaseEntity

interface ActionCommand<T : BaseEntity<*>> {
    fun execute(entity: T)
}