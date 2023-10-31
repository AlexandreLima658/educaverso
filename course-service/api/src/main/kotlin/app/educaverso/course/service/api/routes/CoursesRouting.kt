package app.educaverso.course.service.api.routes

import app.educaverso.course.service.application.courses.create.CreateCourseUseCase
import app.educaverso.course.service.core.courses.commands.CreateCourse
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.courses() {

    val createCourse by inject<CreateCourseUseCase>()

    route("/courses") {
        post {
            val command = call.receive<CreateCourse>()

            val output = createCourse.execute(command)

            call.respond(output)
        }
    }
}
