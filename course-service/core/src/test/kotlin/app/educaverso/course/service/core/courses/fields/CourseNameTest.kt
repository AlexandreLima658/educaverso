package app.educaverso.course.service.core.courses.fields

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class CourseNameTest {

    @Test
    fun `should create a new course name`() {
        // Given
        var aName = "Course name"

        // When
        var aCourseName = CourseName(aName)

        // Then
        assertEquals(aCourseName.value, aName)
    }


    @Test
    fun `should launch an exception when the course name is empty`() {
        // Given
        var aName = ""

        // When
        var aError = assertFails { CourseName(aName) }

        // Then
        assertEquals(aError.message, "Course name cannot be empty")
    }


    @Test
    fun `should launch an exception when the course name is greater than 255 characters`() {
        // Given
        var aName = "a".repeat(256)

        // When
        var aError = assertFails { CourseName(aName) }

        // Then
        assertEquals(aError.message, "Course name cannot be longer than 255 characters")
    }

}