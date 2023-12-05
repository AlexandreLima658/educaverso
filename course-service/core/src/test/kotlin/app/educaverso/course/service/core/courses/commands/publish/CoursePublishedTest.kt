package app.educaverso.course.service.core.courses.commands.publish

import app.educaverso.commons.domain.values.CourseId
import org.junit.Test
import kotlin.test.assertEquals

class CoursePublishedTest {

    @Test
    fun `should create a course published event`() {
        // Given
        val courseId = CourseId.generate().value.toString()

        // When
        val event = CoursePublished(
            courseId
        )

        // Then
        assertEquals(event.name(), "course.published")
        assertEquals(event.courseId, courseId)

    }

}