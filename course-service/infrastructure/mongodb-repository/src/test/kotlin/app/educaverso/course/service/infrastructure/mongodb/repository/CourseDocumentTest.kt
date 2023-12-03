package app.educaverso.course.service.infrastructure.mongodb.repository

import app.educaverso.commons.domain.value.objects.CourseId
import junit.framework.TestCase.assertTrue
import org.junit.Test

class CourseDocumentTest {

    @Test
    fun `should convert to course`() {
        // Given
        val courseDocument = CourseDocument(
            id = CourseId.generate().value.toString(),
            name = "Course Name",
            published = true
        )

        // When
        val course = courseDocument.toCourse()

        // Then
        assertTrue(course.id.value.toString() == courseDocument.id)
        assertTrue(course.name.value == courseDocument.name)
        assertTrue(course.published == courseDocument.published)
    }
}