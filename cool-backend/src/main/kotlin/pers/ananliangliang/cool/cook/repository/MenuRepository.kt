package pers.ananliangliang.cool.cook.repository

import org.springframework.data.jpa.repository.JpaRepository
import pers.ananliangliang.cool.cook.domain.Menu

interface MenuRepository : JpaRepository<Menu, Long> {

    fun getByCreatedById(userId: Long?): List<Menu>
}