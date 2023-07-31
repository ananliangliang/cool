package pers.ananliangliang.cool.order.repository

import org.springframework.data.jpa.repository.JpaRepository
import pers.ananliangliang.cool.order.domain.Food

interface FoodRepository : JpaRepository<Food, Long>