package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.course.service.core.courses.Course

class UnpublishCourse : ActionCommand<Course> {
    override fun execute(entity: Course) {
        entity.published = false
        // TODO emitir o evento de curso publicado
    }

}