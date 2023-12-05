package app.educaverso.course.service.application.courses.publish

import app.educaverso.commons.domain.values.CourseId
import app.educaverso.course.service.core.courses.commands.publish.PublishCourse

interface PublishCourseUseCase {

    fun execute(courseId: CourseId, command: PublishCourse)

}