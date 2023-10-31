package app.educaverso.course.service.application.courses.create

import app.educaverso.course.service.core.courses.commands.CreateCourse

interface CreateCourseUseCase {
    fun execute(createCourse: CreateCourse): CreateCourseOutput

}