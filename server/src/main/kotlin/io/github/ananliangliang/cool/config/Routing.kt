package pers.ananliangliang.todo.config

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.authenticate
import io.ktor.server.auth.authentication
import io.ktor.server.auth.jwt.JWTPrincipal
import io.ktor.server.plugins.NotFoundException
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.datetime.Clock
import kotlinx.datetime.toJavaInstant
import org.koin.ktor.ext.inject
import pers.ananliangliang.todo.Greeting
import pers.ananliangliang.todo.dto.Task
import pers.ananliangliang.todo.dto.auth.LoginReq
import pers.ananliangliang.todo.service.AuthService
import pers.ananliangliang.todo.service.TaskService
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Ktor: ${Greeting().greet()}")
        }
        route("/todo") {
            route("/tasks") {
                val taskService: TaskService by inject()
                get {
                    val a = taskService.selectAll()
                    call.respond(a)
                }
                get("/{id}") {
                    val id = call.parameters["id"]?.toLongOrNull() ?: throw IllegalArgumentException("Invalid task ID")
                    val task = taskService.selectById(id) ?: throw NotFoundException("Task with ID $id not found")
                    call.respond(task)
                }
                post {
                    val task = call.receive<Task>()
                    val id = taskService.create(task)
                    call.respond(HttpStatusCode.Created, id)
                }
                delete("/{id}") {
                    val id = call.parameters["id"]?.toLongOrNull() ?: throw IllegalArgumentException("Invalid task ID")
                    taskService.delete(id)
                    call.respond(HttpStatusCode.NoContent)
                }
                put("/{id}") {
                    val id = call.parameters["id"]?.toLongOrNull() ?: throw IllegalArgumentException("Invalid task ID")
                    val task = call.receive<Task>()
                    taskService.update(id, task)
                    call.respond(HttpStatusCode.NoContent)
                }
                patch("/{id}") {
                    val id = call.parameters["id"]?.toLongOrNull() ?: throw IllegalArgumentException("Invalid task ID")
                    val task = call.receive<Task>()
                    taskService.updatePartially(id, task)
                    call.respond(HttpStatusCode.NoContent)
                }
            }
            route("/auth") {
                val authService: AuthService by inject()
                post("/login") {
                    val req = call.receive<LoginReq>()
                    val userEntity = authService.login(req)
                    val jwtSecret = environment.config.property("jwt.secret").getString()
                    val jwtIssuer = environment.config.property("jwt.issuer").getString()


                    val token = JWT.create()
                        .withIssuer(jwtIssuer)
                        .withClaim("username", userEntity.username)
                        .withClaim("name",userEntity.name )
                        .withExpiresAt(Clock.System.now().plus(30.minutes).toJavaInstant())
                        .sign(Algorithm.HMAC256(jwtSecret))
                    call.respond(token)
                }
                authenticate("auth-jwt") {
                    get("/me") {
                        val principal = call.authentication.principal<JWTPrincipal>()
                            ?: throw NotFoundException("User not authenticated")
                        val username = principal.payload.getClaim("username").asString()
                        call.respondText("Hello, $username!")
                    }
                }
            }
        }


    }
}
