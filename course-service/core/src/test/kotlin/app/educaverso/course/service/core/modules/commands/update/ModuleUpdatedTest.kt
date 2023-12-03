package app.educaverso.course.service.core.modules.commands.update

import kotlin.test.Test
import kotlin.test.assertEquals

class ModuleUpdatedTest {

    @Test
    fun `should create a module updated event`() {
        // Given
        val moduleId = "moduleId"
        val name = "name"

        // When
        val event = ModuleUpdated(
            moduleId,
            name
        )

        // Then
        assertEquals(event.name(), "module.updated")
        assertEquals(event.moduleId, moduleId)
        assertEquals(event.name, name)

    }


}