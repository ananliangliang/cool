package io.github.ananliangliang.cool.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class User {
    @Id
    @GeneratedValue
    var id: Long = 0L
    var name: String = ""
    var username: String = ""
    var password: String = ""
}