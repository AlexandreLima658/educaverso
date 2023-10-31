package app.educaverso.commons.domain.events

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

object DomainEventDispatcher : EventDispatcher {

    private val handlers: MutableMap<String, MutableList<EventHandler>> = mutableMapOf()

    override fun register(handler: EventHandler) {
        require(!has(handler)) { return }

        this.handlers.computeIfAbsent(handler.eventName()) { mutableListOf() }.add(handler)
    }

    override fun remove(handler: EventHandler) {
        if (has(handler))
            this.handlers[handler.eventName()]?.remove(handler)
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

    override fun has(handler: EventHandler): Boolean {
        return this.handlers.containsKey(handler.eventName()) && this.handlers[handler.eventName()]!!.contains(handler)
    }

    override fun clear() {
        this.handlers.clear()
    }

    override fun handlers() = this.handlers.toMap()
}