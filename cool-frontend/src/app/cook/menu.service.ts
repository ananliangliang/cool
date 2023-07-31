import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Menu} from "./menu";

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
}
