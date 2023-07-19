package pers.ananliangliang.cool.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.DelegatingPasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    @Suppress("DEPRECATION")
    fun passwordEncoder(): PasswordEncoder {

        val idForEncoder = "bcrypt"

        return DelegatingPasswordEncoder(
            idForEncoder, mapOf(
                "noop" to NoOpPasswordEncoder.getInstance(),
                "bcrypt" to BCryptPasswordEncoder(),
            )
        )
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf{ it.disable() }
        http.httpBasic(Customizer.withDefaults())
//        http.authorizeHttpRequests { it.anyRequest().authenticated() }
        return http.build()
    }


}