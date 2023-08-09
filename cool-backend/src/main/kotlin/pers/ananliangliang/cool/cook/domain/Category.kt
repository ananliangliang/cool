package pers.ananliangliang.cool.cook.domain

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import pers.ananliangliang.cool.common.BaseEntity

@Entity(name = "cook_category")
class Category(
    var name: String?,
    var menuId: Long?,
    @ManyToMany @JoinTable(
        name = "cook_category_food",
        joinColumns = [JoinColumn(name = "categoryId")],
        inverseJoinColumns = [JoinColumn(name = "foodId")]
    ) val foods: List<Food>,
) : BaseEntity()