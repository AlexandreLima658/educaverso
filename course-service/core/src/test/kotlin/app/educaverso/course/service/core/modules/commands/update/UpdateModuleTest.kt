package app.educaverso.course.service.core.modules.commands.update

import app.educaverso.commons.domain.values.CourseId
import app.educaverso.course.service.core.modules.commands.create.CreateModule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class UpdateModuleTest {
    @Test
    fun `should update module`() {
        // Given
        var (module, _) = CreateModule(
            name = "Module name",
            courseId = CourseId.generate().value.toString(),
        ).execute()

        var command = UpdateModule(
            name = "New module name",
        )

        // When
        val event = module.execute(command)

        // Then
        assertEquals(module.name.value, command.name)
        assertTrue(event is ModuleUpdated)
    }

}