package app.educaverso.course.service.api.plugins

import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.compression.*
import io.ktor.server.plugins.contentnegotiation.*
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
}

