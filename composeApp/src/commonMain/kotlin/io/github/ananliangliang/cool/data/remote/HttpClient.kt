package io.github.ananliangliang.cool.data.remote

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.http.URLProtocol.Companion.HTTP
import io.ktor.serialization.kotlinx.json.*

val httpClient = HttpClient {
    install(ContentNegotiation) { json() }
    defaultRequest {
        url {
            protocol = HTTP
            host = "192.168.77.99"
            port = 8080
            path("api/")
        }
    }
}
