package pers.ananliangliang.cool.sys.domain

import jakarta.persistence.Entity
import pers.ananliangliang.cool.common.BaseEntity

@Entity(name = "sys_user")
class User (
    var name: String?
) : BaseEntity()