package pers.ananliangliang.cool.order.repository

import org.springframework.data.jpa.repository.JpaRepository
import pers.ananliangliang.cool.order.domain.Menu

interface MenuRepository : JpaRepository<Menu, Long> {

    fun getByCreatedById(userId: Long?): List<Menu>
}