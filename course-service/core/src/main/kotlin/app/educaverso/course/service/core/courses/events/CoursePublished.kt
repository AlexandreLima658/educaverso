package app.educaverso.course.service.core.courses.events

import app.educaverso.commons.domain.events.Event

data class CoursePublished(
    val courseId: String
) : Event() {

    override fun name(): String {
        return "course.published"
    }
}