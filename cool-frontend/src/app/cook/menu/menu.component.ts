import {Component, OnInit} from '@angular/core';
import {MenuService} from "../menu.service";
import {Menu} from "../menu";
import {ActivatedRoute} from "@angular/router";

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


  addFoodNum(id: number) {
    let food = this.menu?.foods.find(it => it.id === id)!
    food.num ??= 0
    food.num++
  }

  removeFoodNum(id: number) {
    let food = this.menu?.foods.find(it => it.id === id)!
    food.num!--
  }

}
