package app.educaverso.commons.domain.events

interface EventDispatcher<T : Event> {
    fun register(handler: EventHandler<T>)
    fun remove(handler: EventHandler<T>)
    fun dispatch(event: T)
    fun has(handler: EventHandler<T>): Boolean
    fun clear()
    fun handlers(): Map<String, List<EventHandler<T>>>
}