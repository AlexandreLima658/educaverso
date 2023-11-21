package app.educaverso.course.service.core.courses.commands.publish

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.course.service.core.courses.Course

class PublishCourse() : ActionCommand<Course>() {

    override fun execute(entity: Course) {
        entity.published = true

        this.event = CoursePublished(
            courseId = entity.id.value.toString()
        )
    }

}