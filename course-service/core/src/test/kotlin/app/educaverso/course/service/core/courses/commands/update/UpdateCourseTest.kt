package app.educaverso.course.service.core.courses.commands.update

import app.educaverso.course.service.core.courses.commands.create.CreateCourse
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class UpdateCourseTest {

    @Test
    fun `should update a course`() {

        // Given
        var (course, _) = CreateCourse(
            name = "Course name"
        ).execute()

        // When
        var updateCourseCommand = UpdateCourse(
            name = "New course name"
        )

        val event = course.execute(updateCourseCommand)

        // Then
        assertEquals(course.name.value, updateCourseCommand.name)
        assertTrue(event is CourseUpdated)

    }


}