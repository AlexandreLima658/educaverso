package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.entities.BaseEntity
import org.junit.Test
import kotlin.test.assertEquals

class UpdateCourseTest {

    @Test
    fun `should update a course`() {

        // Given
        var course = BaseEntity.execute(
            CreateCourse(
                name = "Course name"
            )
        )

        // When
        var updateCourseCommand = UpdateCourse(
            name = "New course name"
        )
        course.execute(updateCourseCommand)

        // Then
        assertEquals(course.name.value, updateCourseCommand.name)

    }


}