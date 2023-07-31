package pers.ananliangliang.cool.cook.repository

import org.springframework.data.jpa.repository.JpaRepository
import pers.ananliangliang.cool.cook.domain.Food

interface FoodRepository : JpaRepository<Food, Long>