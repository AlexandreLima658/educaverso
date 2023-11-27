package app.educaverso.course.service.core.modules.commands.deactivate

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.course.service.core.modules.Module

class DeactivateModule : ActionCommand<Module, ModuleDeactivated>() {
    override fun execute(entity: Module) {
        entity.activated = false

        this.event = ModuleDeactivated(
            moduleId = entity.id.value.toString()
        )
    }

}