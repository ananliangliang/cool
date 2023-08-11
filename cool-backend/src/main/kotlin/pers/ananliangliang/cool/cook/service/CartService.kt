package pers.ananliangliang.cool.cook.service

import org.springframework.stereotype.Service
import pers.ananliangliang.cool.cook.domain.Cart
import pers.ananliangliang.cool.cook.domain.Food
import pers.ananliangliang.cool.cook.repository.CartRepository
import pers.ananliangliang.cool.cook.repository.FoodRepository

@Service
class CartService(
    private val repository: CartRepository,
) {
    fun increaseFood(menuId: Long, foodId: Long) {
        repository.getByMenuIdAndFoodId(menuId, foodId)?.let {
            it.num += 1
            repository.save(it)
        } ?: repository.save(Cart(menuId, foodId, 1))
    }

    fun decreaseFood(menuId: Long, foodId: Long) {
        repository.getByMenuIdAndFoodId(menuId, foodId)?.let {
            if (it.num > 1) {
                it.num -= 1
                repository.save(it)
            } else {
                repository.delete(it)
            }
        }
    }

    fun getCarts(menuId: Long) = repository.getByMenuId(menuId)


}