package pers.ananliangliang.cool.cook.controller

import org.springframework.web.bind.annotation.*
import pers.ananliangliang.cool.cook.service.CartService

@CrossOrigin
@RestController
@RequestMapping("/cook")
class CartController(
    private val service: CartService,
) {

    @PutMapping("/menus/{menuId}/foods/{foodId}/increase")
    fun increaseFood(@PathVariable menuId: Long, @PathVariable foodId: Long) = service.increaseFood(menuId, foodId)

    @PutMapping("/menus/{menuId}/foods/{foodId}/decrease")
    fun decreaseFood(@PathVariable menuId: Long, @PathVariable foodId: Long) = service.decreaseFood(menuId, foodId)
}