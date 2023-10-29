package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.commands.FactoryMethodCommand
import app.educaverso.commons.domain.events.DomainEventDispatcher
import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.courses.events.CourseCreated
import app.educaverso.course.service.core.courses.value.objects.CourseName

class CreateCourse(val aName: String) : FactoryMethodCommand<Course> {

    private val dispatcher = DomainEventDispatcher

    override fun execute(): Course {

        val course = Course(
            id = CourseId.generate(),
            name = CourseName(aName),
            published = false
        )

        dispatcher.dispatch(
            CourseCreated(
                courseId = course.id.value.toString(),
                courseName = course.name.value
            )
        )

        return course
    }

}