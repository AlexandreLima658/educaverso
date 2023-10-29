package app.educaverso.course.service.core.courses.events

import app.educaverso.commons.domain.events.Event

data class CourseCreated(
    val courseId: String,
    val courseName: String
) : Event() {

    override fun name(): String {
        return "course.created"
    }
}