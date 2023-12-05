package app.educaverso.course.service.infrastructure.mongodb.repository

import app.educaverso.commons.domain.values.CourseId
import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.courses.fields.CourseName
import org.bson.codecs.pojo.annotations.BsonId

data class CourseDocument(
    @BsonId val id: String,
    val name: String,
    val published: Boolean
) {

    fun toCourse(): Course {
        return Course(
            id = CourseId.fromString(id),
            name = CourseName(name),
            published = published
        )
    }

}