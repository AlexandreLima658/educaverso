package app.educaverso.course.service.api.plugins

import app.educaverso.course.service.application.courses.create.CreateCourseUseCase
import app.educaverso.course.service.application.courses.create.CreateCourseUseCaseImpl
import app.educaverso.course.service.application.courses.publish.PublishCourseUseCase
import app.educaverso.course.service.application.courses.publish.PublishCourseUseCaseImpl
import app.educaverso.course.service.application.courses.unpublish.UnpublishCourseUseCase
import app.educaverso.course.service.application.courses.unpublish.UnpublishCourseUseCaseImpl
import app.educaverso.course.service.application.courses.update.UpdateCourseUseCase
import app.educaverso.course.service.application.courses.update.UpdateCourseUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCases = module {
    singleOf(::CreateCourseUseCaseImpl) { bind<CreateCourseUseCase>() }
    singleOf(::UpdateCourseUseCaseImpl) { bind<UpdateCourseUseCase>() }
    singleOf(::PublishCourseUseCaseImpl) { bind<PublishCourseUseCase>() }
    singleOf(::UnpublishCourseUseCaseImpl) { bind<UnpublishCourseUseCase>() }
}