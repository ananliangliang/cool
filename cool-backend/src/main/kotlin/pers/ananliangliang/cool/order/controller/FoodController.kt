package pers.ananliangliang.cool.order.controller

import org.springframework.web.bind.annotation.*
import pers.ananliangliang.cool.order.domain.Food
import pers.ananliangliang.cool.order.service.FoodService

@RestController
@RequestMapping("/order")
class FoodController(
    private val service: FoodService,
) {

    @PostMapping("/menus/{menuId}/foods")
    fun createFood(@RequestBody food: Food, @PathVariable menuId: Long) = service.createFood(food, menuId)



}