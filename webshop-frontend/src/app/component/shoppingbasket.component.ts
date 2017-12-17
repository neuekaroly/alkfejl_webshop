import { Component, Input, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { GameService } from '../service/game.service';
import { OrderService } from '../service/order.service';
import { Router } from '@angular/router';
import {BasketItem} from "../model/basketitem";
import {Order} from "../model/order";
import {OrderItem} from "../model/orderitem";

@Component({
  selector: 'shoppingbasket',
  templateUrl: './shoppingbasket.component.html'
})

export class ShoppingBasketComponent {

  sum: number;
  paymentByCreditCard: boolean;
  constructor(private userService: UserService, private router: Router, private orderService: OrderService) {
      this.totalPrice();
      this.paymentByCreditCard = false;
  }

  totalPrice() {
      this.sum = 0;
      var i: number;
      for(i = 0; i < this.userService.basketItems.length; i++) {
          this.sum = this.sum + this.userService.basketItems[i].price * this.userService.basketItems[i].quantity;
      }
  }

  paymentByCreditCardChecked(event) {
      if (event.target.checked){
        this.paymentByCreditCard = true;
      } else {
        this.paymentByCreditCard = false;
      }
    }

  orderTheShoppingBasket(): void {
    this.totalPrice();
    var i: number;
    var orderItems: OrderItem[];
    orderItems = [];
    for(i = 0; i < this.userService.basketItems.length; i++) {
        let orderItem = new OrderItem(this.userService.basketItems[i].quantity, this.userService.basketItems[i].gameid);
        orderItems.push(orderItem);
    }
    
    let order = new Order(this.sum, this.paymentByCreditCard, orderItems);
    console.log("ORDER: ",order);
    this.orderService.addNewOrder(order).subscribe(
        result => { console.log(result);
            this.userService.basketItems = [];
            this.userService.writeCartToDataBase(); 
    },  
        error => console.log(error)
       );
  }

  goToShop(): void {
    this.router.navigate(['/store']);
  }
}
