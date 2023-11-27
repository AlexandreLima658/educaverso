package app.educaverso.course.service.core.modules.commands.activate

import app.educaverso.commons.domain.events.Event

data class ModuleActivated(
    val moduleId: String
) : Event() {
    override fun name(): String {
        return "module.activated"
    }
}
