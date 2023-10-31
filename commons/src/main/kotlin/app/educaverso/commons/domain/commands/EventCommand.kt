package app.educaverso.commons.domain.commands

import app.educaverso.commons.domain.events.DomainEventDispatcher
import app.educaverso.commons.domain.events.Event

interface EventCommand {
    fun dispatch(event: Event) {
        DomainEventDispatcher.dispatch(event)
    }
}