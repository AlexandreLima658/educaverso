package app.educaverso.commons.domain.commands

import app.educaverso.commons.domain.entities.BaseEntity

abstract class FactoryMethodCommand<T : BaseEntity<*>> : EventCommand(){
    abstract fun execute(): T
}