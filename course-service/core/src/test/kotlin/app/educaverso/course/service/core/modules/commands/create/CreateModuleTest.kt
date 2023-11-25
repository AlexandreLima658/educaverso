package app.educaverso.course.service.core.modules.commands.create

import app.educaverso.commons.domain.value.objects.CourseId
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull


class CreateModuleTest {

    @Test
    fun `should create a module`() {
        // Given
        val name = "Module 1"
        val courseId = CourseId.generate().value.toString()
        val command = CreateModule(name, courseId)

        // When
        val module = command.execute()

        // Then
        assertNotNull(module.id)
        assertEquals(name, module.name.value)
        assertEquals(courseId, module.courseId.value.toString())
        assertFalse(module.activated)
        assertEquals("module.created", command.event?.name())
        assertEquals(module.id.value.toString(), command.event?.moduleId)
        assertEquals(name, command.event?.moduleName)
        assertEquals(courseId, command.event?.courseId)
    }

}