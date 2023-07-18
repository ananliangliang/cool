package pers.ananliangliang.cool.common

import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import pers.ananliangliang.cool.sys.domain.User
import java.util.*


internal class SpringSecurityAuditorAware : AuditorAware<User> {
    override fun getCurrentAuditor(): Optional<User> {
        return Optional.ofNullable(SecurityContextHolder.getContext())
            .map(SecurityContext::getAuthentication)
            .filter(Authentication::isAuthenticated)
            .map(Authentication::getPrincipal)
            .map { it as User }
    }
}