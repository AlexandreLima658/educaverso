package app.educaverso.course.service.core.courses.commands

import app.educaverso.course.service.core.courses.commands.create.CreateCourse
import app.educaverso.course.service.core.courses.commands.publish.PublishCourse
import org.junit.Test
import kotlin.test.assertTrue

class PublishCourseTest {

    @Test
    fun `should publish a course`() {
        // Given
        var course = CreateCourse(
            name = "Course name"
        ).execute()


        // When
        course.execute(PublishCourse())

        // Then
        assertTrue(course.published)

    }

}