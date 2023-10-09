package app.educaverso.commons.domain.commands

import app.educaverso.commons.domain.entities.BaseEntity

interface CreateCommand<T : BaseEntity<*>> {
    fun execute(): T
}