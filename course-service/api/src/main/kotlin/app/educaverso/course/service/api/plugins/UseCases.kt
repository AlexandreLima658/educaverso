package app.educaverso.course.service.api.plugins

import app.educaverso.course.service.application.courses.create.CreateCourseUseCase
import app.educaverso.course.service.application.courses.create.CreateCourseUseCaseImpl
import app.educaverso.course.service.core.courses.CourseRepository
import app.educaverso.course.service.infrastructure.repository.courses.CourseRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCases = module {
    singleOf(::CreateCourseUseCaseImpl) { bind<CreateCourseUseCase>() }
}