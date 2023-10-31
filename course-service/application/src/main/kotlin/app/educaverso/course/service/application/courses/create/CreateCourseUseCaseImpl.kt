package app.educaverso.course.service.application.courses.create

import app.educaverso.commons.domain.entities.BaseEntity
import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.courses.CourseRepository
import app.educaverso.course.service.core.courses.commands.CreateCourse
import app.educaverso.course.service.core.courses.events.CourseCreated

class CreateCourseUseCaseImpl(private val repository: CourseRepository) : CreateCourseUseCase {
    override fun execute(createCourse: CreateCourse): CreateCourseOutput {

        val course = BaseEntity.execute(createCourse)

        repository.persist(course)

        createCourse.dispatch(
            mapToCourseCreatedEvent(course)
        )

        return mapToCreateCourseOutput(course)
    }

    private fun mapToCourseCreatedEvent(course: Course) = CourseCreated(
        courseId = course.id.value.toString(),
        courseName = course.name.value
    )

    private fun mapToCreateCourseOutput(course: Course) = CreateCourseOutput(
        id = course.id.value.toString()
    )

}