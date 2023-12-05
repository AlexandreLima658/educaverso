package app.educaverso.course.service.core.modules.commands.create

import app.educaverso.commons.domain.commands.FactoryMethodCreate
import app.educaverso.commons.domain.values.CourseId
import app.educaverso.course.service.core.modules.Module
import app.educaverso.course.service.core.modules.fields.ModuleName

data class CreateModule(val name: String, val courseId: String) :
    FactoryMethodCreate<Module, ModuleCreated> {

    override fun execute(): Pair<Module, ModuleCreated> {

        val module = Module(
            courseId = CourseId.fromString(courseId),
            name = ModuleName(name),
            activated = false
        )

        val event = ModuleCreated(
            moduleId = module.id.value.toString(),
            moduleName = name,
            courseId = courseId
        )

        return Pair(module, event)
    }

}