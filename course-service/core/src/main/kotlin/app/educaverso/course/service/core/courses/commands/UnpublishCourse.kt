package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.commands.ActionCommand
import app.educaverso.course.service.core.courses.Course

class UnpublishCourse : ActionCommand<Course> {

    override fun execute(course: Course) {
        course.published = false
    }

}