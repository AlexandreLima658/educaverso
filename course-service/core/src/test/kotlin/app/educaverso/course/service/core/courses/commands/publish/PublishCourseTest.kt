package app.educaverso.course.service.core.courses.commands.publish

import app.educaverso.course.service.core.courses.commands.create.CreateCourse
import org.junit.Test
import kotlin.test.assertTrue

class PublishCourseTest {

    @Test
    fun `should publish a course`() {
        // Given
        var (course, _) = CreateCourse(
            name = "Course name"
        ).execute()


        // When
        val event = course.execute(PublishCourse())

        // Then
        assertTrue(course.published)
        assertTrue(event is CoursePublished)

    }

}