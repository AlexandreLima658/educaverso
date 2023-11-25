package app.educaverso.course.service.core.courses.commands

import app.educaverso.course.service.core.courses.commands.create.CreateCourse
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
        val aCourse = command.execute()

        // Then
        assertNotNull(aCourse.id)
        assertEquals(aCourse.name.value, command.name)
        assertFalse(aCourse.published)

        assertNotNull(command.event)
        assertNotNull(command.event?.courseId)
        assertNotNull(command.event?.courseName)
        assertEquals(command.event?.name(), "course.created")
        assertNotNull(command.event?.occurredOn)
        assertEquals(command.event?.courseId, aCourse.id.value.toString())
        assertEquals(command.event?.courseName, aCourse.name.value)
    }

}