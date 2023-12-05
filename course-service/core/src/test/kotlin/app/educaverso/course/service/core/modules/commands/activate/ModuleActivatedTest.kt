package app.educaverso.course.service.core.modules.commands.activate

import app.educaverso.commons.domain.values.ModuleId
import org.junit.Test
import kotlin.test.assertEquals

class ModuleActivatedTest {

    @Test
    fun `should create an activated module event`() {
        // Given
        val moduleId = ModuleId.generate().value.toString()

        // When
        val event = ModuleActivated(moduleId)

        // Then
        assertEquals(event.name(), "module.activated")
        assertEquals(event.moduleId, moduleId)

    }
}