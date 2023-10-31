package app.educaverso.course.service.core.courses

interface CourseRepository {
    fun persist(course: Course)
}