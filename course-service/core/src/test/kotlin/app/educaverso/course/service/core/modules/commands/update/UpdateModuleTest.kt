package app.educaverso.course.service.core.modules.commands.update

import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.modules.commands.create.CreateModule
import kotlin.test.assertEquals
import kotlin.test.Test

class UpdateModuleTest {
    @Test
    fun `should update module`() {
        // Given
        var module = CreateModule(
            name = "Module name",
            courseId = CourseId.generate().value.toString(),
        ).execute()

        // When

        var updateModuleCommand = UpdateModule(
            name = "New module name",
            )
        module.execute(updateModuleCommand)

        // Then
        assertEquals(module.name.value, updateModuleCommand.name)
    }

}