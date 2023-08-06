import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TodoComponent } from "./todo/todo.component";
import {MenuComponent} from "./cook/menu/menu.component";

const routes: Routes = [
  { path: "", component: TodoComponent },
  { path: 'todo', component: TodoComponent },
  { path: 'cook/:id', component: MenuComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
