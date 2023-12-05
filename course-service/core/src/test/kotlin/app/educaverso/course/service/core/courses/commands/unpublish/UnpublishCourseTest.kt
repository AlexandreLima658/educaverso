package app.educaverso.course.service.core.courses.commands.unpublish

import app.educaverso.course.service.core.courses.commands.create.CreateCourse
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class UnpublishCourseTest {
    @Test
    fun `should unpublish a course`() {

        // Given
        var (course, _) = CreateCourse(
            name = "Course name"
        ).execute()


        // When
        val event = course.execute(UnpublishCourse())

        // Then
        assertFalse(course.published)
        assertTrue(event is CourseUnpublished)

    }
}