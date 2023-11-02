package app.educaverso.course.service.infrastructure.mongodb.config

import com.mongodb.kotlin.client.coroutine.MongoClient

private const val URI = "mongodb+srv://thiago:d4u3sADB9RMzRNeV@cluster0.gwulsov.mongodb.net/?retryWrites=true&w=majority"
private const val DATABASE_NAME = "educaverso"
private val client = MongoClient.create(URI)

val database = client.getDatabase(DATABASE_NAME)