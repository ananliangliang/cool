package pers.ananliangliang.cool.order.service

import org.springframework.stereotype.Service
import pers.ananliangliang.cool.common.util.SecurityUtils
import pers.ananliangliang.cool.order.domain.Menu
import pers.ananliangliang.cool.order.repository.MenuRepository

@Service
class MenuService(
    private val repository: MenuRepository,
) {

    fun getMenus() = repository.getByCreatedById(SecurityUtils.getCurrUserId())

    fun createMenu(menu: Menu) {
        val currUserId = SecurityUtils.getCurrUserId()
        repository.save(menu)
    }

    fun updateMenu(menu: Menu) = repository.save(menu)

    fun deleteMenu(id: Long) = repository.deleteById(id)

}