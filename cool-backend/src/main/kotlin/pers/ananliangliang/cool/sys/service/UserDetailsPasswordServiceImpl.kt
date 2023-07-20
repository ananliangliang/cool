package pers.ananliangliang.cool.sys.service

import jakarta.transaction.Transactional
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsPasswordService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import pers.ananliangliang.cool.sys.domain.vo.UserVo
import pers.ananliangliang.cool.sys.repository.UserRepository

@Service
class UserDetailsPasswordServiceImpl(
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository,
) : UserDetailsPasswordService {

    @Transactional
    override fun updatePassword(user: UserDetails, newPassword: String): UserDetails {
        val userVo = user as UserVo
        userRepository.updatePasswordById(newPassword, userVo.id)
        return userVo.copy(password = newPassword)
    }
}