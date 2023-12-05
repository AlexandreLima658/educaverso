package app.educaverso.course.service.core.modules.commands.activate

import app.educaverso.commons.domain.values.CourseId
import app.educaverso.course.service.core.modules.commands.create.CreateModule
import junit.framework.TestCase.assertTrue
import org.junit.Test

class ActivateModuleTest {
    @Test
    fun `should activate a module`(){
        // Given
        var (module, _) = CreateModule(
            name ="Module name",
            courseId = CourseId.generate().value.toString(),

        ).execute()

        val command = ActivateModule()

        // When
        val event = module.execute(command)

        // Then
        assertTrue(module.activated)
        assertTrue(event is ModuleActivated)
    }

}