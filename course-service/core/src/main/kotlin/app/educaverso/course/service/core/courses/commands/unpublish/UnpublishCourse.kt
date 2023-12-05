package app.educaverso.course.service.core.courses.commands.unpublish

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.course.service.core.courses.Course

class UnpublishCourse : ActionCommand<Course, CourseUnpublished> {

    override fun execute(entity: Course): CourseUnpublished {
        entity.published = false

        return CourseUnpublished(
            courseId = entity.id.value.toString()
        )
    }

}