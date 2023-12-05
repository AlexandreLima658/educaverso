package app.educaverso.course.service.application.courses.unpublish

import app.educaverso.commons.domain.commands.dispatch
import app.educaverso.commons.domain.values.CourseId
import app.educaverso.course.service.core.courses.CourseRepository
import app.educaverso.course.service.core.courses.commands.unpublish.UnpublishCourse

class UnpublishCourseUseCaseImpl(private val repository: CourseRepository) : UnpublishCourseUseCase {

    override fun execute(courseId: CourseId, command: UnpublishCourse) {

        val course = repository.findBy(courseId)

        val event = course.execute(command)

        repository.update(course)

        dispatch(event)

    }

}