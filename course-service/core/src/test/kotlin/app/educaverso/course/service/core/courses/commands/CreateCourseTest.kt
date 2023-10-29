package app.educaverso.course.service.core.courses.commands

import app.educaverso.commons.domain.entities.BaseEntity
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class CreateCourseTest {

    @Test
    fun `should create a new course`() {
        // Given
        var createCourse = CreateCourse(
            aName = "Course name"
        )

        // When
        var aCourse = BaseEntity.execute(createCourse)

        // Then
        assertNotNull(aCourse.id)
        assertEquals(aCourse.name.value, createCourse.aName)
    }

}