package pers.ananliangliang.cool.common

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*

@MappedSuperclass
abstract class BaseEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long?,
    @CreatedDate var createdDate: Date?,
    @LastModifiedDate var lastModifiedDate: Date?,
) {
    constructor() : this(null, null, null)
}