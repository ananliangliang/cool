package pers.ananliangliang.cool.cook.service

import org.springframework.stereotype.Service
import pers.ananliangliang.cool.common.util.SecurityUtils
import pers.ananliangliang.cool.cook.domain.Menu
import pers.ananliangliang.cool.cook.repository.MenuRepository

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
    fun getMenuById(id: Long) = repository.getReferenceById(id)

}