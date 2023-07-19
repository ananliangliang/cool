package pers.ananliangliang.cool.sys.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import pers.ananliangliang.cool.common.BaseEntity

@Entity(name = "sys_user")
class User (
    var name: String?,
    var username: String?,
    var phone: String?,
    var email: String?,
    @JsonIgnore var password: String?,
) : BaseEntity() {

    constructor() : this(null, null, null, null, null)
}