package elte.alkfejlbead.webshop.service;

import elte.alkfejlbead.webshop.entity.Order;
import elte.alkfejlbead.webshop.entity.User;
import elte.alkfejlbead.webshop.model.api.request.NewOrderDTO;
import elte.alkfejlbead.webshop.repository.OrderRepository;
import elte.alkfejlbead.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class OrderService {
    private UserRepository userRepository;
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    public void addNewOrder(NewOrderDTO newOrder) {
        User user = userRepository.findOne(newOrder.getUserID());
        Order order = new Order();
        order.setOrderDate(Calendar.getInstance().getTime());
        order.setDone(false);
        order.setUser(user);
        orderRepository.save(order);
    }
}
