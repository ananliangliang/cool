import {Component, OnInit} from '@angular/core';
import {MenuService} from "../menu.service";
import {Menu} from "../menu";
import {ActivatedRoute} from "@angular/router";
import {Food} from "../food";
import {Cart} from "../cart";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit{

  menu: Menu | undefined
  carts: Cart[] = []

  constructor(
    private route: ActivatedRoute,
    private service: MenuService,
  ) {
  }
  ngOnInit(): void {
    const menuId = parseInt(this.route.snapshot.paramMap.get('id')!)
    this.service.getMenuById(menuId).subscribe(it => this.menu = it)
    this.service.getCarts(menuId).subscribe(it => this.carts = it)
  }

  checkIfFoodInCart(food: Food) {
    return this.carts.some(it => it.foodId === food?.id)
  }

  getFoodNum(food?: Food) {
    return this.carts.find(it => it.foodId === food?.id)?.num
  }


  addFoodNum(food: Food) {
    const cart = this.carts.find(it => it.foodId === food?.id);
    if (cart)
      cart.num++
    else
      this.carts.push({menuId: this.menu?.id!, foodId: food.id, num: 1})
    this.service.increaseFoodNum(this.menu!.id, food.id).subscribe()
  }

  removeFoodNum(food: Food) {
    const cart = this.carts.find(it => it.foodId === food?.id);
    if (cart && cart.num !=1)
      cart.num--
    else
      this.carts = this.carts.filter(it => it.foodId !== food?.id)
    this.service.decreaseFoodNum(this.menu!.id, food.id).subscribe()
  }
}
