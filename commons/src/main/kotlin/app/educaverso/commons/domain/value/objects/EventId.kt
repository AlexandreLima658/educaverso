package app.educaverso.commons.domain.value.objects

import java.util.UUID

class EventId(value: UUID) : BaseId<UUID>(value) {
    companion object {
        fun generate(): EventId {
            return EventId(UUID.randomUUID())
        }
    }
}