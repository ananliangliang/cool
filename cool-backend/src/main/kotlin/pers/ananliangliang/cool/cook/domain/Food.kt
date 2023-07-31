package pers.ananliangliang.cool.cook.domain

import jakarta.persistence.Entity
import pers.ananliangliang.cool.common.BaseEntity
import java.math.BigDecimal

@Entity(name = "cook_food")
class Food(
    var name: String?,
    var price: BigDecimal?,
    var description: String?,
    var image: String?,
    var menuId: Long,
) : BaseEntity()