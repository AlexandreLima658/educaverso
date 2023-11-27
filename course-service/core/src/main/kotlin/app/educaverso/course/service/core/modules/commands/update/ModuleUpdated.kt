package app.educaverso.course.service.core.modules.commands.update

import app.educaverso.commons.domain.events.Event

data class ModuleUpdated(
    val moduleId: String,
    val name: String
) : Event() {
    override fun name(): String {
        return "module.updated"
    }
}

