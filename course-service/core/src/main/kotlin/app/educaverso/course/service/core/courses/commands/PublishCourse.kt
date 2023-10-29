package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.course.service.core.courses.Course

class PublishCourse : ActionCommand<Course> {
    override fun execute(entity: Course) {
        entity.published = true
        // TODO emitir o evento de curso publicado
    }

}