package app.educaverso.course.service.infrastructure.repository.courses

import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.courses.CourseRepository

class CourseRepositoryImpl : CourseRepository{
    override fun persist(course: Course) {
        println("Persisting course")
    }
}