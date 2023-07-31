package pers.ananliangliang.cool.cook.controller

import org.springframework.web.bind.annotation.*
import pers.ananliangliang.cool.cook.domain.Food
import pers.ananliangliang.cool.cook.service.FoodService

@RestController
@RequestMapping("/order")
class FoodController(
    private val service: FoodService,
) {

    @PostMapping("/menus/{menuId}/foods")
    fun createFood(@RequestBody food: Food, @PathVariable menuId: Long) = service.createFood(food, menuId)



}