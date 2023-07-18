package pers.ananliangliang.cool.sys.repository

import org.springframework.data.jpa.repository.JpaRepository
import pers.ananliangliang.cool.sys.domain.User

interface UserRepository : JpaRepository<User, Long> {
}