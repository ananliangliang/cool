package pers.ananliangliang.cool.sys.domain

import jakarta.persistence.Entity
import pers.ananliangliang.cool.common.BaseEntity

@Entity(name = "sys_role")
class Role (
    name: String?,
    remark: String?,
    authority: String?,
) : BaseEntity() {


}
