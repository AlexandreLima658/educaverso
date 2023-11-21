package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.entities.BaseEntity
import app.educaverso.course.service.core.courses.commands.create.CreateCourse
import app.educaverso.course.service.core.courses.commands.unpublish.UnpublishCourse
import org.junit.Test
import kotlin.test.assertFalse

class UnpublishCourseTest {
    @Test
    fun `should unpublish a course`() {

        // Given
        var course = BaseEntity.execute(
            CreateCourse(
                name = "Course name"
            )
        )

        // When
        course.execute(UnpublishCourse())

        // Then
        assertFalse(course.published)

    }
}