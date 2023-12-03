package app.educaverso.course.service.application.courses.create

import app.educaverso.course.service.core.courses.CourseRepository
import app.educaverso.course.service.core.courses.commands.create.CreateCourse
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.times

class CreateCourseUseCaseImplTest {


    @Test
    fun `should persist a course`() {
        // Given
        val repository = mock<CourseRepository> {

        }

        val useCase = CreateCourseUseCaseImpl(repository)
        val command = CreateCourse(
            name = "A Course"
        )

        // When
        val output = useCase.execute(command)

        // Then
        assertNotNull(output.id)
        verify(repository, times(1)).persist(any())

    }


}