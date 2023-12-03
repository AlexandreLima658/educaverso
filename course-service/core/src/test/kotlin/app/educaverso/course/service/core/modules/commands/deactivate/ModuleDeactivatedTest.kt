package app.educaverso.course.service.core.modules.commands.deactivate

import org.junit.Test
import kotlin.test.assertEquals

class ModuleDeactivatedTest {

    @Test
    fun `should create a module deactivated event`() {
        // Given
        val moduleId = "moduleId"

        // When
        val event = ModuleDeactivated(
            moduleId
        )

        // Then
        assertEquals(event.name(), "module.deactivated")
        assertEquals(event.moduleId, moduleId)

    }
}