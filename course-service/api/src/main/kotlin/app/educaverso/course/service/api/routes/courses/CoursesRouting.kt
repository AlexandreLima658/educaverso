package app.educaverso.course.service.api.routes.courses

import app.educaverso.commons.domain.values.CourseId
import app.educaverso.course.service.application.courses.create.CreateCourseUseCase
import app.educaverso.course.service.application.courses.publish.PublishCourseUseCase
import app.educaverso.course.service.application.courses.unpublish.UnpublishCourseUseCase
import app.educaverso.course.service.application.courses.update.UpdateCourseUseCase
import app.educaverso.course.service.core.courses.commands.create.CreateCourse
import app.educaverso.course.service.core.courses.commands.publish.PublishCourse
import app.educaverso.course.service.core.courses.commands.unpublish.UnpublishCourse
import app.educaverso.course.service.core.courses.commands.update.UpdateCourse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.courses() {

    val createCourse by inject<CreateCourseUseCase>()
    val updateCourse by inject<UpdateCourseUseCase>()
    val publishCourse by inject<PublishCourseUseCase>()
    val unpublishCourse by inject<UnpublishCourseUseCase>()

    route("courses") {

        post {
            val command = call.receive<CreateCourse>()

            val output = createCourse.execute(command)

            call.respond(
                status = HttpStatusCode.Created,
                message = output
            )
        }

        put("{courseId}") {

            val courseId = call.parameters["courseId"]

            val command = call.receive<UpdateCourse>()

            updateCourse.execute(CourseId.fromString(courseId.toString()), command)

            call.respond("Course updated")
        }

        put("{courseId}/publish") {

            val courseId = call.parameters["courseId"]

            val command = PublishCourse()

            publishCourse.execute(CourseId.fromString(courseId.toString()), command)

            call.respond("Course published")
        }

        put("{courseId}/unpublish") {

            val courseId = call.parameters["courseId"]

            val command = UnpublishCourse()

            unpublishCourse.execute(CourseId.fromString(courseId.toString()), command)

            call.respond("Course unpublished")
        }
    }
}
