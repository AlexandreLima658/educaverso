package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.courses.value.objects.CourseName

class UpdateCourse(val newName: String) : ActionCommand<Course> {
    override fun execute(course: Course) {
        course.name = CourseName(newName)
    }
}