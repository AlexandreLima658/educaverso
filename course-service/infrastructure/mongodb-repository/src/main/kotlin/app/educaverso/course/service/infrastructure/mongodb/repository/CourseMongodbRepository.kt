package app.educaverso.course.service.infrastructure.mongodb.repository

import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.courses.Course
import app.educaverso.course.service.core.courses.CourseRepository
import app.educaverso.course.service.infrastructure.mongodb.config.database
import com.mongodb.client.model.Filters.eq
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking

class CourseMongodbRepository : CourseRepository {

    private val collection = database.getCollection<CourseDocument>("courses")

    override fun persist(course: Course) {
        runBlocking {
            collection.insertOne(
                CourseDocument(
                    _id = course.id.value.toString(),
                    name = course.name.value,
                    published = course.published
                )
            )
        }
    }

    override fun update(course: Course) {

        runBlocking {
            collection.replaceOne(
                eq(CourseDocument::_id.name, course.id.value.toString()),
                CourseDocument(
                    _id = course.id.value.toString(),
                    name = course.name.value,
                    published = course.published
                )
            )
        }
    }

    override fun findBy(id: CourseId): Course = runBlocking {

        val result = collection.find(
            eq(CourseDocument::_id.name, id.value.toString())
        ).firstOrNull()?.toCourse()

        require(result != null) { "Course not found" }

        result
    }

}