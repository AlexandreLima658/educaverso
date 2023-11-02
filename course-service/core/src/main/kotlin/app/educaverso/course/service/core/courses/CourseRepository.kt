package app.educaverso.course.service.core.courses

import app.educaverso.commons.domain.value.objects.CourseId

interface CourseRepository {
    fun persist(course: Course)
    fun update(course: Course)
    fun findBy(id: CourseId): Course
}