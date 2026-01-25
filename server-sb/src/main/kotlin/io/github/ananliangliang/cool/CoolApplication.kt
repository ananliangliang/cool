package io.github.ananliangliang.cool

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoolApplication

fun main(args: Array<String>) {
	runApplication<CoolApplication>(*args)
}
