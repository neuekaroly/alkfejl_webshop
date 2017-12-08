import {User} from "./user";
import {OrderItem} from "./orderitem";
import {Status} from "./status";

export class Order {
  orderDate: string;
  orderPrice: number;
  paymentByDreditCard: boolean;
  isDone: boolean;
  user: User;
  orderITems: OrderItem[];
  status: Status;

  constructor () {}
}
