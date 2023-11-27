package app.educaverso.course.service.core.modules.commands.activate

import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.modules.commands.create.CreateModule
import kotlin.test.Test
import kotlin.test.assertTrue

class ActivateModuleTest {
    @Test
    fun `should activate a module`(){
        // Given
        var module = CreateModule(
            name ="Module name",
            courseId = CourseId.generate().value.toString(),

        ).execute()

        // When
        ActivateModule().execute(module)

        // Then
        assertTrue(module.activated)
    }

}