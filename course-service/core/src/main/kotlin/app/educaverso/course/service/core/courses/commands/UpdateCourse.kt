package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.courses.value.objects.CourseName

class UpdateCourse(val newName: String) : ActionCommand<Course> {
    override fun execute(entity: Course) {
        entity.name = CourseName(newName)
        //TODO publicar o evento de curso atualizado
    }
}