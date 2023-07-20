package pers.ananliangliang.cool.common.util

import org.springframework.security.core.context.SecurityContextHolder

class SecurityUtils {
    companion object {
        fun getCurrentUser() = SecurityContextHolder.getContext().authentication
    }
}