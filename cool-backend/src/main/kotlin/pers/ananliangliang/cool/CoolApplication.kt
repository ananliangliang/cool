package pers.ananliangliang.cool

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class CoolApplication

fun main(args: Array<String>) {
	runApplication<CoolApplication>(*args)
}
