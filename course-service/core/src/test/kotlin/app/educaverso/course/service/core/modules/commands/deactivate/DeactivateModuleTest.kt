package app.educaverso.course.service.core.modules.commands.deactivate

import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.modules.commands.create.CreateModule
import org.junit.Test
import kotlin.test.assertFalse

class DeactivateModuleTest {
    @Test
    fun `should deactivate a module`() {
        // Given
        var module = CreateModule(
            name ="Module name",
            courseId = CourseId.generate().value.toString(),

        ).execute()

        // When
        DeactivateModule().execute(module)

        // Then
        assertFalse(module.activated)
        
    }

}