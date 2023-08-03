import {Food} from "./food";

export interface Menu {
  id: number
  title: string
  subtitle?: string
  description?: string
  foods: Food[]
}
