package pers.ananliangliang.cool.cook.repository

import org.springframework.data.jpa.repository.JpaRepository
import pers.ananliangliang.cool.cook.domain.Cart

interface CartRepository: JpaRepository<Cart, Long> {
    fun getByMenuId(menuId: Long): List<Cart>
    fun getByMenuIdAndFoodId(menuId: Long, foodId: Long): Cart?
}