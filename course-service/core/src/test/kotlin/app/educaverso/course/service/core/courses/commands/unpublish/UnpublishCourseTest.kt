package app.educaverso.course.service.core.courses.commands.unpublish

import app.educaverso.course.service.core.courses.commands.create.CreateCourse
import org.junit.Test
import kotlin.test.assertFalse

class UnpublishCourseTest {
    @Test
    fun `should unpublish a course`() {

        // Given
        var course = CreateCourse(
            name = "Course name"
        ).execute()


        // When
        course.execute(UnpublishCourse())

        // Then
        assertFalse(course.published)

    }
}