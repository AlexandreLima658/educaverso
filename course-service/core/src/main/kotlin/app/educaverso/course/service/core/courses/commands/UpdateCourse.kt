package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.value.objects.CourseName

class UpdateCourse(val newName: CourseName) : ActionCommand<Course> {

    override fun execute(entity: Course) {

        entity.name = newName

    }
}