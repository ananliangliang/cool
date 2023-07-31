package pers.ananliangliang.cool.order.service

import org.springframework.stereotype.Service
import pers.ananliangliang.cool.order.domain.Food
import pers.ananliangliang.cool.order.repository.FoodRepository

@Service
class FoodService(
    private val repository: FoodRepository,
) {

    fun createFood(food: Food, menuId: Long) {
        food.menuId = menuId
        repository.save(food)
    }
}