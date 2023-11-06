package app.educaverso.course.service.infrastructure.mongodb.config

import com.mongodb.kotlin.client.coroutine.MongoClient

private val URI = System.getenv("MONGODB_URI") ?: "mongodb://localhost:27017"
private const val DATABASE_NAME = "educaverso"
private val client = MongoClient.create(URI)
private val database = client.getDatabase(DATABASE_NAME)

object MongodbConnection {
    fun getDatabase() = database
}