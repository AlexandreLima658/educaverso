package app.educaverso.commons.domain.events

interface EventHandler<T : Event> {
    fun handle(event: T)
    fun eventName(): String

}