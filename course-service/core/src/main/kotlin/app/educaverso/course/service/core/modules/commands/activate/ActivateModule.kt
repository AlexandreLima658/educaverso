package app.educaverso.course.service.core.modules.commands.activate

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.course.service.core.modules.Module
class ActivateModule: ActionCommand<Module, ModuleActivated>() {
    override fun execute(entity: Module) {
        entity.activated = true

        this.event = ModuleActivated(
            moduleId = entity.id.value.toString()
        )
    }
}