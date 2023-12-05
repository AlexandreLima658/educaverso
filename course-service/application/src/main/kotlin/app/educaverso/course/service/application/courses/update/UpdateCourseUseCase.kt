package app.educaverso.course.service.application.courses.update

import app.educaverso.commons.domain.values.CourseId
import app.educaverso.course.service.core.courses.commands.update.UpdateCourse

interface UpdateCourseUseCase {

    fun execute(courseId: CourseId, updateCourse: UpdateCourse)

}