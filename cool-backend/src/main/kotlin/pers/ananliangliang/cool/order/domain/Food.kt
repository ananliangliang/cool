package pers.ananliangliang.cool.order.domain

import jakarta.persistence.Entity
import pers.ananliangliang.cool.common.BaseEntity
import java.math.BigDecimal

@Entity(name = "order_food")
class Food(
    var name: String?,
    var price: BigDecimal?,
    var description: String?,
    var image: String?,
    var menuId: Long,
) : BaseEntity()