package app.educaverso.course.service.core.courses.commands.create

import app.educaverso.commons.domain.commands.FactoryMethodCreate
import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.courses.fields.CourseName

data class CreateCourse(val name: String) : FactoryMethodCreate<Course, CourseCreated> {
    override fun execute(): Pair<Course, CourseCreated> {

        val course = Course(
            name = CourseName(name),
            published = false
        )

        val event = CourseCreated(
            courseId = course.id.value.toString(),
            courseName = name
        )

        return Pair(course, event)
    }
}