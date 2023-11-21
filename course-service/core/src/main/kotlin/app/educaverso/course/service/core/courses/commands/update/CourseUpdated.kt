package app.educaverso.course.service.core.courses.commands.update

import app.educaverso.commons.domain.events.Event

data class CourseUpdated(
    val courseId: String,
    val name: String
) : Event() {

    override fun name(): String {
        return "course.updated"
    }
}