package pers.ananliangliang.cool.cook.domain

import jakarta.persistence.*
import pers.ananliangliang.cool.common.BaseEntity

@Entity(name = "cook_menu")
class Menu(
    val title: String?,
    val subtitle: String?,
    val description: String?,
    @OneToMany @JoinColumn(name = "menuId") val categories: List<Category>,
    @OneToMany
    @JoinColumn(name = "menuId")
    var carts: List<Cart>,
) : BaseEntity()