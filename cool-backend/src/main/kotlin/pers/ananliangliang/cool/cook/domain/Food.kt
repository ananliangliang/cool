package pers.ananliangliang.cool.cook.domain

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinColumns
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import pers.ananliangliang.cool.common.BaseEntity
import java.math.BigDecimal

@Entity(name = "cook_food")
class Food(
    var name: String?,
    var price: BigDecimal?,
    var description: String?,
    var image: String?,
) : BaseEntity()