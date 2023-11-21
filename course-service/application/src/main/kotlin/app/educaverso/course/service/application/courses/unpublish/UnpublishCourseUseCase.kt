package app.educaverso.course.service.application.courses.unpublish

import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.courses.commands.unpublish.UnpublishCourse

interface UnpublishCourseUseCase {

    fun execute(courseId: CourseId, command: UnpublishCourse)

}