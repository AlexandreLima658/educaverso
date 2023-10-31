package app.educaverso.course.service.api.plugins

import app.educaverso.course.service.api.routes.courses
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        courses()
    }
}
