package app.educaverso.commons.domain.entities

import app.educaverso.commons.domain.value.objects.BaseId

abstract class AggregateRoot<Id : BaseId<*>>(id: Id) : BaseEntity<Id>(id)