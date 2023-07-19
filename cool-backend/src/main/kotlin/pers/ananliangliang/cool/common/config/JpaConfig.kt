package pers.ananliangliang.cool.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import pers.ananliangliang.cool.sys.domain.User
import pers.ananliangliang.cool.sys.domain.vo.UserVo
import java.util.*

@EnableJpaAuditing
@Configuration
class JpaConfig {

    @Bean
    fun auditorAware(): AuditorAware<User> {
        return AuditorAware {
            Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .filter { it !is String }
                .map { it as UserVo }
                .map { User().apply { id = it.id } }
        }
    }
}