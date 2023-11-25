package app.educaverso.course.service.core.modules.commands.create

import app.educaverso.commons.domain.events.Event

data class ModuleCreated(
    val moduleId: String,
    val moduleName: String,
    val courseId: String,
) : Event() {
    override fun name() = "module.created"
}
