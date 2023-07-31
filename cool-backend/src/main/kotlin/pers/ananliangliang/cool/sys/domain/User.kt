package pers.ananliangliang.cool.sys.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.JoinFormula
import org.hibernate.annotations.NaturalId
import org.hibernate.proxy.HibernateProxy
import pers.ananliangliang.cool.common.BaseEntity
import java.util.*

@Entity(name = "sys_user")
class User(
    @NaturalId
    var name: String? = null,
    var username: String? = null,
    var phone: String? = null,
    var email: String? = null,
    @JsonIgnore var password: String? = null,
    @Column(name = "role_id") var roleId: Long? = null,
    @JoinColumn(insertable = false, updatable = false) @ManyToOne var role: Role? = null,
) : BaseEntity()