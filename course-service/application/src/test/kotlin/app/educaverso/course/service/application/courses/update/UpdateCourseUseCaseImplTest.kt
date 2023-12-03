package app.educaverso.course.service.application.courses.update

import app.educaverso.course.service.application.courses.create.CreateCourseUseCaseImpl
import app.educaverso.course.service.core.courses.CourseRepository
import app.educaverso.course.service.core.courses.commands.create.CreateCourse
import app.educaverso.course.service.core.courses.commands.update.UpdateCourse
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.times

class UpdateCourseUseCaseImplTest{

    @Test
    fun `should update course`(){

        // Given
        val aCourse = CreateCourse(
            name = "A Course"
        ).execute()

        val repository = mock<CourseRepository> {
            on { findBy(aCourse.id) } doReturn  aCourse
        }

        val useCase = UpdateCourseUseCaseImpl(repository)
        val command = UpdateCourse(
            name = "A new Course"
        )

        // When
        useCase.execute(aCourse.id, command)

        // Then
        assertEquals(aCourse.name.value, command.name)

        Mockito.verify(repository, times(1)).update(any())

    }

}