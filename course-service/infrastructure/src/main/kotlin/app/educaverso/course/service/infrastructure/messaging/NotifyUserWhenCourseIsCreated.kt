package app.educaverso.course.service.infrastructure.messaging

import app.educaverso.commons.domain.events.Event
import app.educaverso.commons.domain.events.EventHandler

class NotifyUserWhenCourseIsCreated : EventHandler {
    override fun handle(event: Event) {
        println("Notify user via kafka")
    }

    override fun eventName() = "course.created"
}