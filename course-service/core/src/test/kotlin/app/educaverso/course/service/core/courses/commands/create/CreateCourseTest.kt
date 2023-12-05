package app.educaverso.course.service.core.courses.commands.create

import junit.framework.TestCase.*
import org.junit.Test

class CreateCourseTest {

    @Test
    fun `should create a new course`() {
        // Given
        val command = CreateCourse(
            name = "Course name"
        )

        // When
        val (aCourse, event) = command.execute()

        // Then
        assertNotNull(aCourse.id)
        assertEquals(aCourse.name.value, command.name)
        assertFalse(aCourse.published)

        assertNotNull(event)
        assertNotNull(event?.courseId)
        assertNotNull(event?.courseName)
        assertEquals(event?.name(), "course.created")
        assertNotNull(event?.occurredOn)
        assertEquals(event?.courseId, aCourse.id.value.toString())
        assertEquals(event?.courseName, aCourse.name.value)
    }

}