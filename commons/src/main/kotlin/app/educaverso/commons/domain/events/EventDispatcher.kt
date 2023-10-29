package app.educaverso.commons.domain.events

interface EventDispatcher {
    fun register(handler: EventHandler)
    fun remove(handler: EventHandler)
    fun dispatch(event: Event)
    fun has(handler: EventHandler): Boolean
    fun clear()
    fun handlers(): Map<String, List<EventHandler>>
}