package pers.ananliangliang.cool.common

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import pers.ananliangliang.cool.sys.domain.User
import java.util.*

@Suppress("UNUSED")
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    @ManyToOne @CreatedBy var createdBy: User? = null,
    @CreatedDate var createdDate: Date? = null,
    @ManyToOne @LastModifiedBy var lastModifiedBy: User? = null,
    @LastModifiedDate var lastModifiedDate: Date? = null,
)