package pers.ananliangliang.cool.order.controller

import org.springframework.web.bind.annotation.*
import pers.ananliangliang.cool.order.domain.Menu
import pers.ananliangliang.cool.order.service.MenuService

@RestController
@RequestMapping("/order")
class MenuController(
    private val service: MenuService,
) {

    @GetMapping("/menus")
    fun getMenus() = service.getMenus()

    @PostMapping("/menus")
    fun createMenu(@RequestBody menu: Menu) = service.createMenu(menu)

    @PutMapping("/menus")
    fun updateMenu(@RequestBody menu: Menu) = service.updateMenu(menu)

    @DeleteMapping("/menu/{id}")
    fun deleteMenu(@PathVariable id: Long) = service.deleteMenu(id)
}