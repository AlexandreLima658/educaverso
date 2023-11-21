package app.educaverso.commons.domain.value.objects

import java.util.*

class ModuleId(value: UUID) : BaseId<UUID>(value) {
    companion object {
        fun generate(): ModuleId {
            return ModuleId(UUID.randomUUID())
        }

        fun fromString(value: String): ModuleId {
            return ModuleId(UUID.fromString(value))
        }

    }
}