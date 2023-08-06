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
    var menuId: Long,
    @OneToOne
    @JoinColumns(
        JoinColumn(name = "menuId", referencedColumnName = "menuId", insertable = false, updatable = false),
        JoinColumn(name = "id", referencedColumnName = "foodId", insertable = false, updatable = false)
    )var cart: Cart?
) : BaseEntity()