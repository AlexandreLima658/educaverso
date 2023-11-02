package app.educaverso.course.service.application.courses.unpublish

import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.courses.CourseRepository
import app.educaverso.course.service.core.courses.commands.UnpublishCourse

class UnpublishCourseUseCaseImpl(private val repository: CourseRepository) : UnpublishCourseUseCase {

    override fun execute(courseId: CourseId, command: UnpublishCourse) {

        val course = repository.findBy(courseId)

        course.execute(command)

        repository.update(course)

    }

}