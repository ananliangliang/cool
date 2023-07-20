package pers.ananliangliang.cool.sys.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import pers.ananliangliang.cool.sys.domain.User

interface UserRepository : JpaRepository<User, Long> {
    fun getByUsernameOrPhoneOrEmail(username: String, phone: String, email: String): User?

    @Modifying
    @Query("update sys_user su set su.password = :password where su.id = :id")
    fun updatePasswordById(password: String, id: Long)
}