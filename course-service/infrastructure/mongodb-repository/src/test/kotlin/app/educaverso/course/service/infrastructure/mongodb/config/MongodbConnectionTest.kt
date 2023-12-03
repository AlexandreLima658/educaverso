package app.educaverso.course.service.infrastructure.mongodb.config

import org.junit.Test
import kotlin.test.assertNotNull

class MongodbConnectionTest {

    @Test
    fun `should return a database instance`() {
        // Given
        val database = MongodbConnection.getDatabase()

        // Then
        assertNotNull(database)
        assertNotNull(database.name)
    }

}