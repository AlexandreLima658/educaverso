package app.educaverso.course.service.api.plugins

import app.educaverso.course.service.core.courses.CourseRepository
import app.educaverso.course.service.infrastructure.mongodb.repository.CourseMongodbRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositories = module {
    singleOf(::CourseMongodbRepository) { bind<CourseRepository>() }
}