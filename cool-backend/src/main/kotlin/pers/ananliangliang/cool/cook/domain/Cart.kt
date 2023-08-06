package pers.ananliangliang.cool.cook.domain

import jakarta.persistence.Entity
import pers.ananliangliang.cool.common.BaseEntity

@Entity(name = "cook_cart")
class Cart(
    var menuId : Long?,
    var foodId: Long?,
    var num: Int,
):BaseEntity()