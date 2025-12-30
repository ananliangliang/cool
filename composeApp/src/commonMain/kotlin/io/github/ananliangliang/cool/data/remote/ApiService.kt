package io.github.ananliangliang.cool.data.remote

import io.github.ananliangliang.cool.dto.todo.Task
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class ApiService(private val client: HttpClient) {

    suspend fun getTask(id: Long): Task {
        return client.get("todo/tasks/$id").body<Task>()
    }

    suspend fun getTasks(): List<Task> {
        return client.get("todo/tasks").body<List<Task>>()
    }

    suspend fun deleteTask(id: Long) {
        client.delete("todo/tasks/$id")
    }

    suspend fun postTask(task: Task) {
        client.post("todo/tasks") {
            contentType(ContentType.Application.Json)
            setBody(task)
        }
    }

    suspend fun putTask(task: Task) {
        client.put("todo/tasks/${task.id}") {
            contentType(ContentType.Application.Json)
            setBody(task)
        }
    }

    suspend fun patchTask(task: Task) {
        client.patch("todo/tasks/${task.id}") {
            contentType(ContentType.Application.Json)
            setBody(task)
        }
    }


}