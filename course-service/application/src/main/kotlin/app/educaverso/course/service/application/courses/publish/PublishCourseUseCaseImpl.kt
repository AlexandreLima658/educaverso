package app.educaverso.course.service.application.courses.publish

import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.courses.CourseRepository
import app.educaverso.course.service.core.courses.commands.PublishCourse
import app.educaverso.course.service.core.courses.events.CoursePublished

class PublishCourseUseCaseImpl(private val repository: CourseRepository) : PublishCourseUseCase {

    override fun execute(courseId: CourseId, command: PublishCourse) {

        val course = repository.findBy(courseId)

        course.execute(command)

        repository.update(course)

        command.dispatch(
            CoursePublished(
                courseId = course.id.value.toString()
            )
        )

    }

}