package pers.ananliangliang.cool.common.util

import org.springframework.security.core.context.SecurityContextHolder
import pers.ananliangliang.cool.sys.domain.vo.UserVo

class SecurityUtils {
    companion object {
        fun getCurrUser() = SecurityContextHolder.getContext().authentication

        fun getCurrUserId(): Long? {
            return when (val principal = getCurrUser().principal) {
                is UserVo -> principal.id
                else -> null
            }
        }
    }
}