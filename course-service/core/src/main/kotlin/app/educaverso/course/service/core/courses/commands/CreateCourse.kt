package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.commands.EventCommand
import app.educaverso.commons.domain.commands.FactoryMethodCommand
import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.courses.value.objects.CourseName

data class CreateCourse(val name: String) : FactoryMethodCommand<Course>, EventCommand {
    override fun execute(): Course {
        return Course(
            name = CourseName(name),
            published = false
        )
    }

}