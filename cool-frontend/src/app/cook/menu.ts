import {Category} from "./category";
import {Cart} from "./cart";
import {Food} from "./food";

export interface Menu {
  id: number
  title: string
  subtitle?: string
  description?: string
  categories: Category[]
  carts: Cart[]

}
