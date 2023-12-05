package app.educaverso.course.service.core.modules.commands.update

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.course.service.core.modules.Module
import app.educaverso.course.service.core.modules.fields.ModuleName

class UpdateModule(val name: String) : ActionCommand<Module, ModuleUpdated> {
    override fun execute(entity: Module): ModuleUpdated {
        entity.name = ModuleName(name)

        return ModuleUpdated(
            moduleId = entity.id.value.toString(),
            name = name
        )
    }
}