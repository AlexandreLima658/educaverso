package app.educaverso.course.service.application.courses.update

import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.courses.CourseRepository
import app.educaverso.course.service.core.courses.commands.update.UpdateCourse

class UpdateCourseUseCaseImpl(private val repository: CourseRepository) : UpdateCourseUseCase {

    override fun execute(courseId: CourseId, updateCourse: UpdateCourse) {

        val course = repository.findBy(courseId)

        course.execute(updateCourse)

        repository.update(course)

        updateCourse.dispatch()

    }

}