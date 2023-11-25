package app.educaverso.commons.domain.commands

import app.educaverso.commons.domain.events.DomainEventDispatcher
import app.educaverso.commons.domain.events.Event

abstract class EventCommand<T : Event> {

    var event: T? = null

    fun dispatch() {
        event?.let {
            DomainEventDispatcher.dispatch(it)
        }
    }

}