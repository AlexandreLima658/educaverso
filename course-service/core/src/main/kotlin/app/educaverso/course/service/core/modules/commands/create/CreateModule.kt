package app.educaverso.course.service.core.modules.commands.create

import app.educaverso.commons.domain.commands.FactoryMethodDispatcherCommand
import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.modules.Module
import app.educaverso.course.service.core.modules.fields.ModuleName

data class CreateModule(val name: String, val courseId: String) :
    FactoryMethodDispatcherCommand<Module, ModuleCreated>() {

    override fun execute(): Module {

        val module = Module(
            courseId = CourseId.fromString(courseId),
            name = ModuleName(name),
            activated = false
        )

        this.event = ModuleCreated(
            moduleId = module.id.value.toString(),
            moduleName = name,
            courseId = courseId
        )

        return module
    }

}