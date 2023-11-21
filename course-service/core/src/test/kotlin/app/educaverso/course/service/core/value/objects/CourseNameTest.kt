package app.educaverso.course.service.core.value.objects

import app.educaverso.course.service.core.modules.value.objects.ModuleName
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class CourseNameTest {

    @Test
    fun `should create a new course name`() {
        // Given
        var aName = "Course name"

        // When
        var aCourseName = ModuleName(aName)

        // Then
        assertEquals(aCourseName.value, aName)
    }


    @Test
    fun `should launch an exception when the course name is empty`() {
        // Given
        var aName = ""

        // When
        var aError = assertFails { ModuleName(aName) }

        // Then
        assertEquals(aError.message, "Course name cannot be empty")
    }

}