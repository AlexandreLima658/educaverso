package app.educaverso.course.service.application.courses.unpublish

import app.educaverso.course.service.core.courses.CourseRepository
import app.educaverso.course.service.core.courses.commands.create.CreateCourse
import app.educaverso.course.service.core.courses.commands.unpublish.UnpublishCourse
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import kotlin.test.assertFalse

class UnpublishCourseUseCaseImplTest {

    @Test
    fun `should unpublish course`() {

        // Given
        val aCourse = CreateCourse(
            name = "Course Name"
        ).execute()

        val repository = mock<CourseRepository> {
            on { findBy(aCourse.id) } doReturn aCourse
        }

        val useCase = UnpublishCourseUseCaseImpl(repository)
        val command = UnpublishCourse()

        // When
        useCase.execute(aCourse.id, command)

        // Then
        assertFalse(aCourse.published)

        verify(repository, times(1)).update(aCourse)
        verify(repository, times(1)).findBy(aCourse.id)

    }

}