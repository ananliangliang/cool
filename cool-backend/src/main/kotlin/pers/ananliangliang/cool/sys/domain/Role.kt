package pers.ananliangliang.cool.sys.domain

import jakarta.persistence.Entity
import pers.ananliangliang.cool.common.BaseEntity

@Entity(name = "sys_role")
class Role (
    var name: String? = null,
    var remark: String? = null,
    var authority: String? = null,
) : BaseEntity()
