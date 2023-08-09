import {Food} from "./food";

export interface Category {
  id: number
  name: string
  foods: Food[]
}
