package app.educaverso.course.service.core.courses.commands.unpublish

import app.educaverso.commons.domain.values.CourseId
import org.junit.Test
import kotlin.test.assertEquals

class CourseUnpublishedTest {

    @Test
    fun `should unpublish a course event`() {

        // Given
        val courseId = CourseId.generate().value.toString()

        // When
        val event = CourseUnpublished(
            courseId = courseId
        )

        // Then
        assertEquals(event.name(), "course.unpublished")
        assertEquals(event.courseId, courseId)

    }
}