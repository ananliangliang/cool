package pers.ananliangliang.cool.order.domain

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import pers.ananliangliang.cool.common.BaseEntity

@Entity(name = "order_menu")
class Menu(
    val name: String?,
    val description: String?,
    @OneToMany @JoinColumn(name = "menuId") val foods: List<Food>?,
) : BaseEntity()