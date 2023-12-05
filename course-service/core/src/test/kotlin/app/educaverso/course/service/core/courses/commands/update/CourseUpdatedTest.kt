package app.educaverso.course.service.core.courses.commands.update

import app.educaverso.commons.domain.values.CourseId
import org.junit.Test
import kotlin.test.assertEquals

class CourseUpdatedTest {

    @Test
    fun `should create a course updated event`() {
        // Given
        val courseId = CourseId.generate().value.toString()
        val name = "Course Name"

        // When
        val event = CourseUpdated(
            courseId = courseId,
            name = name
        )

        // Then
        assertEquals(event.name(), "course.updated")
        assertEquals(event.courseId, courseId)
        assertEquals(event.name, name)
    }

}