package io.github.ananliangliang.cool

import io.github.ananliangliang.cool.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
}