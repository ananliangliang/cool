package pers.ananliangliang.cool.cook.controller

import org.springframework.web.bind.annotation.*
import pers.ananliangliang.cool.cook.domain.Menu
import pers.ananliangliang.cool.cook.service.MenuService

@CrossOrigin
@RestController
@RequestMapping("/cook")
class MenuController(
    private val service: MenuService,
) {

    @GetMapping("/menus/{id}")
    fun getMenuById(@PathVariable id: Long) = service.getMenuById(id)

    @GetMapping("/menus")
    fun getMenus() = service.getMenus()

    @PostMapping("/menus")
    fun createMenu(@RequestBody menu: Menu) = service.createMenu(menu)

    @PutMapping("/menus")
    fun updateMenu(@RequestBody menu: Menu) = service.updateMenu(menu)

    @DeleteMapping("/menu/{id}")
    fun deleteMenu(@PathVariable id: Long) = service.deleteMenu(id)
}