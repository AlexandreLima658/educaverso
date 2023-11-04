package app.educaverso.course.service.api.plugins

import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.compression.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import org.koin.ktor.plugin.Koin

fun Application.module() {

    configureRouting()

    install(Compression) {
        gzip()
    }

    install(ContentNegotiation) {

        gson {
            setPrettyPrinting()
            setLenient()
        }

    }

    install(Koin) {
        modules(repositories)
        modules(useCases)
    }

    install(StatusPages) {
        exception<Throwable> { call, cause ->

            when (cause) {
                is IllegalArgumentException -> call.respond(
                    message = "{\"msg\": ${cause.message}}",
                    status = HttpStatusCode.BadRequest
                )

                else -> call.respond(
                    message = "{\"msg\": ${cause.message}}",
                    status = HttpStatusCode.InternalServerError
                )
            }
        }
    }
}

