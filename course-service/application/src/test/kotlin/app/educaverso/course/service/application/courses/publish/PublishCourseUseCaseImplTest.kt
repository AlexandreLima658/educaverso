package app.educaverso.course.service.application.courses.publish

import app.educaverso.course.service.core.courses.CourseRepository
import app.educaverso.course.service.core.courses.commands.create.CreateCourse
import app.educaverso.course.service.core.courses.commands.publish.PublishCourse
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import kotlin.test.assertTrue

class PublishCourseUseCaseImplTest {

    @Test
    fun `should publish an course`() {

        // Given
        val aCourse = CreateCourse(
            name = "Course Name"
        ).execute()

        val repository = mock<CourseRepository> {
            on { findBy(aCourse.id) } doReturn aCourse
        }

        val useCase = PublishCourseUseCaseImpl(repository)
        val command = PublishCourse()

        // When
        useCase.execute(aCourse.id, command)

        // Then
        assertTrue(aCourse.published)

        verify(repository, times(1)).update(aCourse)
        verify(repository, times(1)).findBy(aCourse.id)

    }
}