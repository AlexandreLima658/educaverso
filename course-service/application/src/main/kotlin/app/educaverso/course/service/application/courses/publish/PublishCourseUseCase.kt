package app.educaverso.course.service.application.courses.publish

import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.courses.commands.publish.PublishCourse

interface PublishCourseUseCase {

    fun execute(courseId: CourseId, command: PublishCourse)

}