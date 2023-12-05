package app.educaverso.commons.domain.entities

import app.educaverso.commons.domain.values.BaseId

abstract class AggregateRoot<Id : BaseId<*>>(id: Id) : BaseEntity<Id>(id)