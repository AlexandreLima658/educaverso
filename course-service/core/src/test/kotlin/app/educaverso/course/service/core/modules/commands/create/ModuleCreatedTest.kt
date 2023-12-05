package app.educaverso.course.service.core.modules.commands.create

import app.educaverso.commons.domain.values.CourseId
import app.educaverso.commons.domain.values.ModuleId
import org.junit.Test
import kotlin.test.assertEquals

class ModuleCreatedTest {

    @Test
    fun `should create a module created event`() {
        // Given
        val moduleId = ModuleId.generate().value.toString()
        val moduleName = "Module 1"
        val courseId = CourseId.generate().value.toString()

        // When
        val event = ModuleCreated(
            moduleId, moduleName, courseId
        )

        // Then

        assertEquals(event.name(), "module.created")
        assertEquals(event.moduleId, moduleId)
        assertEquals(event.moduleName, moduleName)
        assertEquals(event.courseId, courseId)

    }
}