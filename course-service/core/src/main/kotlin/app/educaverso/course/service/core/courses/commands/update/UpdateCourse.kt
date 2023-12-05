package app.educaverso.course.service.core.courses.commands.update

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.courses.fields.CourseName

class UpdateCourse(val name: String) : ActionCommand<Course, CourseUpdated> {
    override fun execute(entity: Course) : CourseUpdated{

        entity.name = CourseName(name)

        return CourseUpdated(
            courseId = entity.id.value.toString(),
            name = name
        )
    }

}