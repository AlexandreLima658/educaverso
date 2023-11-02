package app.educaverso.commons.domain.value.objects

import java.util.*

class CourseId(value: UUID) : BaseId<UUID>(value) {
    companion object {
        fun generate(): CourseId {
            return CourseId(UUID.randomUUID())
        }

        fun fromString(value: String): CourseId {
            return CourseId(UUID.fromString(value))
        }

    }
}