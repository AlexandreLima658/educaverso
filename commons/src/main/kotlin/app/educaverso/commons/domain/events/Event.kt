package app.educaverso.commons.domain.events

import app.educaverso.commons.domain.value.objects.EventId
import java.time.Instant

abstract class Event(
    val eventId: EventId = EventId.generate(),
    val occurredOn: Instant = Instant.now()
) {
    abstract fun name(): String
}