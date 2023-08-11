import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Menu} from "./menu";
import {Cart} from "./cart";

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(
    private http: HttpClient,
  ) { }

  getMenuById(id: Number) {
    return this.http.get<Menu>(`http://localhost:8080/cook/menus/${id}`)
  }

  increaseFoodNum(menuId: number, foodId: number) {
    return this.http.put<void>(`http://localhost:8080/cook/menus/${menuId}/foods/${foodId}/increase`, null)
  }

  decreaseFoodNum(menuId: number, foodId: number) {
    return this.http.put<void>(`http://localhost:8080/cook/menus/${menuId}/foods/${foodId}/decrease`, null)
  }

  getCarts(menuId: number) {
    return this.http.get<Cart[]>(`http://localhost:8080/cook/menus/${menuId}/carts`)
  }
}
