package app.educaverso.course.service.core.modules.commands.create

import app.educaverso.commons.domain.values.CourseId
import app.educaverso.commons.domain.values.ModuleId
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
        val (aModule, event) = command.execute()

        // Then

        assertNotNull { aModule.id }
        assertEquals(aModule.name.value, command.name)
        assertEquals(aModule.courseId, CourseId.fromString(command.courseId))
        assertFalse(aModule.activated)

        assertNotNull(event)
        assertNotNull(event?.courseId)
        assertNotNull(event?.moduleId)
        assertEquals(event?.name(), "module.created")
        assertNotNull(event?.occurredOn)
        assertEquals(event?.courseId, aModule.courseId.value.toString())
        assertEquals(ModuleId.fromString(event!!.moduleId), aModule.id)
        assertEquals(event?.moduleName, aModule.name.value)
    }

}