package app.educaverso.course.service.infrastructure.mongodb.repository

import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.courses.value.objects.CourseName

data class CourseDocument(
    val _id: String,
    val name: String,
    val published: Boolean
) {

    fun toCourse() : Course {
        return Course(
            id = CourseId.fromString(_id),
            name = CourseName(name),
            published = published
        )
    }

}