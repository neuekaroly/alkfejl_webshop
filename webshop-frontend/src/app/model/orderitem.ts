import {Game} from "./game";
import {Order} from "./order";

export class OrderItem {
  quantity: number;
  gameId: number;

  constructor(quantity: number, gameId: number) {
    this.quantity = quantity;
    this.gameId = gameId;
  }
}
