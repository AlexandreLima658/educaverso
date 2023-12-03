package app.educaverso.course.service.core.courses.commands.create

import app.educaverso.commons.domain.commands.FactoryMethodDispatcherCommand
import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.courses.fields.CourseName

data class CreateCourse(val name: String) : FactoryMethodDispatcherCommand<Course, CourseCreated>() {
    override fun execute(): Course {

        val course = Course(
            name = CourseName(name),
            published = false
        )

        this.event = CourseCreated(
            courseId = course.id.value.toString(),
            courseName = name
        )

        return course
    }
}