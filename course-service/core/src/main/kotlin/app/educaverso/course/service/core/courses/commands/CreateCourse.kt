package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.commands.CreateCommand
import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.value.objects.CourseName

class CreateCourse(val aName: CourseName) : CreateCommand<Course> {

    override fun execute(): Course {
        return Course(
            id = CourseId.generate(),
            name = aName
        )
    }

}