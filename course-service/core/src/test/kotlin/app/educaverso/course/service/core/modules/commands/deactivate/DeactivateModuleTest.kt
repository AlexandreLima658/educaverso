package app.educaverso.course.service.core.modules.commands.deactivate

import app.educaverso.commons.domain.values.CourseId
import app.educaverso.course.service.core.modules.commands.create.CreateModule
import junit.framework.TestCase.assertTrue
import org.junit.Test
import kotlin.test.assertFalse

class DeactivateModuleTest {
    @Test
    fun `should deactivate a module`() {
        // Given
        var (module, _) = CreateModule(
            name ="Module name",
            courseId = CourseId.generate().value.toString(),
        ).execute()

        val command = DeactivateModule()

        // When
        val event = module.execute(command)

        // Then
        assertFalse(module.activated)
        assertTrue(event is ModuleDeactivated)
        
    }

}