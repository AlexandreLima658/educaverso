package app.educaverso.course.service.core.courses.commands

import app.educaverso.course.service.core.courses.commands.create.CreateCourse
import app.educaverso.course.service.core.courses.commands.update.UpdateCourse
import org.junit.Test
import kotlin.test.assertEquals

class UpdateCourseTest {

    @Test
    fun `should update a course`() {

        // Given
        var course = CreateCourse(
            name = "Course name"
        ).execute()

        // When
        var updateCourseCommand = UpdateCourse(
            name = "New course name"
        )
        course.execute(updateCourseCommand)

        // Then
        assertEquals(course.name.value, updateCourseCommand.name)

    }


}