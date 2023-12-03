package app.educaverso.course.service.core.courses.commands.create

import app.educaverso.commons.domain.value.objects.CourseId
import junit.framework.TestCase
import org.junit.Test

class CourseCreatedTest {

    @Test
    fun `should create a course created event`() {
        // Given
        val courseId = CourseId.generate().value.toString()
        val courseName = "Course Name"

        // When
        val event = CourseCreated(
            courseId = courseId,
            courseName = courseName
        )

        // Then
        TestCase.assertEquals(event.name(), "course.created")
        TestCase.assertEquals(event.courseId, courseId)
        TestCase.assertEquals(event.courseName, courseName)
    }

}