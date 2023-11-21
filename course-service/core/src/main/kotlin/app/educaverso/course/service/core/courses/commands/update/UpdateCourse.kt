package app.educaverso.course.service.core.courses.commands.update

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.courses.fields.CourseName

class UpdateCourse(val name: String) : ActionCommand<Course>() {
    override fun execute(entity: Course) {
        entity.name = CourseName(name)

        this.event = CourseUpdated(
            courseId = entity.id.value.toString(),
            name = name
        )
    }

}