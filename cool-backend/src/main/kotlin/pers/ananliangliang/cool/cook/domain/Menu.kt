package pers.ananliangliang.cool.cook.domain

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import pers.ananliangliang.cool.common.BaseEntity

@Entity(name = "cook_menu")
class Menu(
    val title: String?,
    val subtitle: String?,
    val description: String?,
    @OneToMany @JoinColumn(name = "menuId") val foods: List<Food>?,
) : BaseEntity()