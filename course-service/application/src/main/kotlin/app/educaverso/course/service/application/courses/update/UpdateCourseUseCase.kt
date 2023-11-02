package app.educaverso.course.service.application.courses.update

import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.courses.commands.UpdateCourse

interface UpdateCourseUseCase {

    fun execute(courseId: CourseId, updateCourse: UpdateCourse)

}