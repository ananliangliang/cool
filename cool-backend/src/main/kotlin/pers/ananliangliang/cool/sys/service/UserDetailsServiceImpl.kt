package pers.ananliangliang.cool.sys.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import pers.ananliangliang.cool.sys.domain.vo.UserVo
import pers.ananliangliang.cool.sys.repository.UserRepository

@Service
class UserDetailsServiceImpl(
    private val userRepository: UserRepository,
): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        if (username == null) throw UsernameNotFoundException("username is null")
        return userRepository.getByUsernameOrPhoneOrEmail(username, username, username)
            ?.let { UserVo(it.id!!, it.name!!, it.username!!, it.password!!) }
            ?: throw UsernameNotFoundException("username not found")
    }
}