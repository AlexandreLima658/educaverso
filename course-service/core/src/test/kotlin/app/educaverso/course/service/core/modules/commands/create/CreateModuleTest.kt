package app.educaverso.course.service.core.modules.commands.create

import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.commons.domain.value.objects.ModuleId
import junit.framework.TestCase.*
import org.junit.Test

class CreateModuleTest {

    @Test
    fun `should create a module`() {

        // Given
        val name = "Module 1"
        val courseId = CourseId.generate().value.toString()
        val command = CreateModule(
            name = name,
            courseId = courseId
        )

        // When
        val aModule = command.execute()

        // Then

        assertNotNull { aModule.id }
        assertEquals(aModule.name.value, command.name)
        assertEquals(aModule.courseId, CourseId.fromString(command.courseId))
        assertFalse(aModule.activated)

        assertNotNull(command.event)
        assertNotNull(command.event?.courseId)
        assertNotNull(command.event?.moduleId)
        assertEquals(command.event?.name(), "module.created")
        assertNotNull(command.event?.occurredOn)
        assertEquals(command.event?.courseId, aModule.courseId.value.toString())
        assertEquals(ModuleId.fromString(command.event!!.moduleId), aModule.id)
        assertEquals(command.event?.moduleName, aModule.name.value)
    }

}