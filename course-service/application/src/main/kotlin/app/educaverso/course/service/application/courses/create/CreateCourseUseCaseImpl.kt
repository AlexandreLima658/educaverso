package app.educaverso.course.service.application.courses.create

import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.courses.CourseRepository
import app.educaverso.course.service.core.courses.commands.create.CreateCourse

class CreateCourseUseCaseImpl(private val repository: CourseRepository) : CreateCourseUseCase {
    override fun execute(command: CreateCourse): CreateCourseOutput {

        val course = command.execute()

        repository.persist(course)

        command.dispatch()

        return mapToCreateCourseOutput(course)
    }

    private fun mapToCreateCourseOutput(course: Course) = CreateCourseOutput(
        id = course.id.value.toString()
    )

}