package elte.alkfejlbead.webshop.controller;

import elte.alkfejlbead.webshop.annotation.Role;
import elte.alkfejlbead.webshop.entity.User;
import elte.alkfejlbead.webshop.model.api.request.NewOrderDTO;
import elte.alkfejlbead.webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Role(User.Role.USER)
    @PostMapping("")
    public void addNewOrder(HttpServletRequest request, @RequestBody NewOrderDTO newOrder) {
        orderService.addNewOrder(newOrder);
    }

    @Role(User.Role.USER)
    @DeleteMapping("/{orderId}")
    public void deleteOrder(HttpServletRequest request, @PathVariable int orderId) {
        orderService.deleteOrder(orderId);
    }
}
