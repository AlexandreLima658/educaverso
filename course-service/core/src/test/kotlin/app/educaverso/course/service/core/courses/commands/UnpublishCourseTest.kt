package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.entities.BaseEntity
import org.junit.Test
import kotlin.test.assertFalse

class UnpublishCourseTest {
    @Test
    fun `should unpublish a course`() {

        // Given
        var course = BaseEntity.execute(
            CreateCourse(
                aName = "Course name"
            )
        )

        // When
        course.execute(UnpublishCourse())

        // Then
        assertFalse(course.published)

    }
}