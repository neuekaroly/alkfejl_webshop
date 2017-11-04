package elte.alkfejlbead.webshop.controller;

import elte.alkfejlbead.webshop.model.api.request.NewOrderDTO;
import elte.alkfejlbead.webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("")
    public void addNewOrder(@RequestBody NewOrderDTO newOrder) {
        orderService.addNewOrder(newOrder);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable int orderId) {
        orderService.deleteOrder(orderId);
    }
}
