package app.educaverso.course.service.core.modules.commands.deactivate

import app.educaverso.commons.domain.events.Event

data class ModuleDeactivated(
    val moduleId: String
) : Event() {
    override fun name(): String {
        return "module.deactivated"
    }
}
