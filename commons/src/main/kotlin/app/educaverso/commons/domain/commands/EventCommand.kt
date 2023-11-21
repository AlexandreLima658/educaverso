package app.educaverso.commons.domain.commands

import app.educaverso.commons.domain.events.DomainEventDispatcher
import app.educaverso.commons.domain.events.Event

abstract class EventCommand {

    var event: Event? = null

    fun dispatch() {
        event?.let {
            DomainEventDispatcher.dispatch(it)
        }
    }

}