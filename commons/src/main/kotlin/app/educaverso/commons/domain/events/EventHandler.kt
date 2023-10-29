package app.educaverso.commons.domain.events

interface EventHandler {
    fun handle(event: Event)
    fun eventName(): String

}