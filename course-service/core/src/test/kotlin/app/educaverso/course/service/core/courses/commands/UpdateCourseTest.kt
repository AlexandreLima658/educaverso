package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.entities.BaseEntity
import app.educaverso.course.service.core.value.objects.CourseName
import org.junit.Test
import kotlin.test.assertEquals

class UpdateCourseTest {

    @Test
    fun `should update a course`() {

        // Given
        var course = BaseEntity.execute(
            CreateCourse(
                aName = CourseName("Course name")
            )
        )

        var updateCourseCommand = UpdateCourse(
            newName = CourseName("New course name")
        )

        // When
        course.execute(updateCourseCommand)

        // Then
        assertEquals(course.name, updateCourseCommand.newName)

    }


}