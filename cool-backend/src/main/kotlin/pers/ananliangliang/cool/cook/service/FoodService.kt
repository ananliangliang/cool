package pers.ananliangliang.cool.cook.service

import org.springframework.stereotype.Service
import pers.ananliangliang.cool.cook.domain.Food
import pers.ananliangliang.cool.cook.repository.FoodRepository

@Service
class FoodService(
    private val repository: FoodRepository,
) {

    fun createFood(food: Food, menuId: Long) {
        food.menuId = menuId
        repository.save(food)
    }
}