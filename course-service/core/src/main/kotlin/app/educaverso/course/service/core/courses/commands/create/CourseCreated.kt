package app.educaverso.course.service.core.courses.commands.create

import app.educaverso.commons.domain.events.Event

data class CourseCreated(
    val courseId: String,
    val courseName: String
) : Event() {
    override fun name() = "course.created"
}