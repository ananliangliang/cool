import {Cart} from "./cart";

export interface Food {
  id: number;
  name: string;
  description?: string;
  price: number;
  cart?: Cart;
}
