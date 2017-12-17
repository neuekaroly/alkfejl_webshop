import {User} from "./user";
import {OrderItem} from "./orderitem";
import {Status} from "./status";

export class Order {
  orderDate: string;
  orderPrice: number;
  paymentByCreditCard: boolean;
  isDone: boolean;
  userId: number;
  orderItems: OrderItem[];
  status: Status;

  constructor (orderPrice: number, paymentByCreditCard: boolean, orderItems: OrderItem[]) {
    this.orderPrice = orderPrice;
    this.paymentByCreditCard = paymentByCreditCard;
    this.orderItems = orderItems;
  }
}
