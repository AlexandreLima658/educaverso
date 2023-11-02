package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.entities.BaseEntity
import org.junit.Test
import kotlin.test.assertTrue

class PublishCourseTest {

    @Test
    fun `should publish a course`() {
        // Given
        var course = BaseEntity.execute(
            CreateCourse(
                name = "Course name"
            )
        )

        // When
        course.execute(PublishCourse())

        // Then
        assertTrue(course.published)

    }

}