package app.educaverso.course.service.core.modules.fields

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails


class ModuleNameTest {


    @Test
    fun `should create a new module name`() {
        // Given
        var aName = "Module name"

        // When
        var aModuleName = ModuleName(aName)

        // Then
        assertEquals(aModuleName.value, aName)
    }

    @Test
    fun `should launch an exception when the module name is empty`() {
        // Given
        var aName = ""

        // When
        var aError = assertFails { ModuleName(aName) }

        // Then
        assertEquals(aError.message, "Module name cannot be empty")
    }

    @Test
    fun `should launch an exception when the module name is longer than 100 characters`() {
        // Given
        var aName = "a".repeat(101)

        // When
        var aError = assertFails { ModuleName(aName) }

        // Then
        assertEquals(aError.message, "Module name cannot be longer than 100 characters")
    }

}