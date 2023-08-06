import {Component, OnInit} from '@angular/core';
import {MenuService} from "../menu.service";
import {Menu} from "../menu";
import {ActivatedRoute} from "@angular/router";
import {Food} from "../food";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit{

  menu: Menu | undefined
  constructor(
    private route: ActivatedRoute,
    private service: MenuService,
  ) {
  }
  ngOnInit(): void {
    this.service.getMenuById(parseInt(this.route.snapshot.paramMap.get('id')!))
      .subscribe(it => this.menu = it)
  }


  addFoodNum(food: Food) {
    if (food.cart)
      food.cart.num++
    else
      food.cart = {num: 1}
    this.service.increaseFoodNum(this.menu!.id, food.id).subscribe()
  }

  removeFoodNum(food: Food) {
    if (food.cart && food.cart.num !=1)
      food.cart.num--
    else
      food.cart = undefined
    this.service.decreaseFoodNum(this.menu!.id, food.id).subscribe()
  }

}
