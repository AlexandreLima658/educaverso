package app.educaverso.commons.domain.entities

import app.educaverso.commons.domain.value.objects.BaseId
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Test
import org.mockito.kotlin.mock
import kotlin.test.assertFalse

class BaseEntityTest {

    @Test
    fun `should has hashCode and equals`() {
        // Given
        val id = mock<BaseId<Int>> {}

        // When
        val baseEntity = object : BaseEntity<BaseId<Int>>(id) {}

        // Then
        assertNotNull(baseEntity.hashCode())
        assertTrue((baseEntity == baseEntity))
    }

    @Test
    fun `should be equals to other BaseEntity with same id`() {
        // Given
        val id = object : BaseId<Int>(1) {}
        val otherId = object : BaseId<Int>(1) {}

        // When
        val baseEntity = object : BaseEntity<BaseId<Int>>(id) {}
        val otherBaseEntity = object : BaseEntity<BaseId<Int>>(otherId) {}

        // Then
        assertTrue(baseEntity.equals(otherBaseEntity))

    }

    @Test
    fun `should be equals to other BaseEntity with same id and different type`() {
        // Given
        val id = object : BaseId<Int>(1) {}
        val otherId = object : BaseId<Int>(2) {}

        // When
        val baseEntity = object : BaseEntity<BaseId<Int>>(id) {}
        val otherBaseEntity = object : BaseEntity<BaseId<Int>>(otherId) {}

        // Then
        assertFalse(baseEntity.equals(otherBaseEntity))

    }

}