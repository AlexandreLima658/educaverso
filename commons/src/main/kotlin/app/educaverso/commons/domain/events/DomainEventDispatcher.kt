package app.educaverso.commons.domain.events

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

object DomainEventDispatcher : EventDispatcher<Event> {

    private val handlers: MutableMap<String, MutableList<EventHandler<Event>>> = mutableMapOf()

    override fun register(handler: EventHandler<Event>) {
        require(!has(handler)) { return }

        this.handlers.computeIfAbsent(handler.eventName()) { mutableListOf() }.add(handler)
    }

    override fun remove(handler: EventHandler<Event>) {

        if (has(handler)) {
            this.handlers[handler.eventName()]?.clear()

            if (this.handlers[handler.eventName()].isNullOrEmpty())
                this.handlers.remove(handler.eventName())

        }

    }

    override fun dispatch(event: Event) {
        runBlocking {
            handlers[event.name()]?.forEach { handler ->
                launch {
                    handler.handle(event)
                }
            }
        }
    }

    override fun has(handler: EventHandler<Event>): Boolean {
        return this.handlers.containsKey(handler.eventName()) && this.handlers[handler.eventName()]!!.contains(handler)
    }

    override fun clear() {
        this.handlers.clear()
    }

    override fun handlers() = this.handlers.toMap()
}