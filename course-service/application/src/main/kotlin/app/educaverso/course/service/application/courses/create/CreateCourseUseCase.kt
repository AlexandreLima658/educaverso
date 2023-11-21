package app.educaverso.course.service.application.courses.create

import app.educaverso.course.service.core.courses.commands.create.CreateCourse

interface CreateCourseUseCase {
    fun execute(createCourse: CreateCourse): CreateCourseOutput

}