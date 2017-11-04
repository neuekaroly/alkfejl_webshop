package elte.alkfejlbead.webshop.service;

import elte.alkfejlbead.webshop.entity.*;
import elte.alkfejlbead.webshop.model.api.request.NewOrderDTO;
import elte.alkfejlbead.webshop.repository.GameRepository;
import elte.alkfejlbead.webshop.repository.OrderRepository;
import elte.alkfejlbead.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class OrderService {
    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private GameRepository gameRepository;

    @Autowired
    public OrderService(UserRepository userRepository, OrderRepository orderRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.gameRepository = gameRepository;
    }

    public void addNewOrder(NewOrderDTO newOrder) {
        User user = userRepository.findOne(newOrder.getUserID());
        List<OrderItem> orderItems = new ArrayList<>();
        Order order = new Order();
        order.setOrderDate(Calendar.getInstance().getTime());
        order.setDone(false);
        order.setUser(user);
        for (int i = 0; i < newOrder.getGameIds().size(); i++) {
            OrderItem orderItem = new OrderItem();
            int gameId = newOrder.getGameIds().get(i);
            Game game = gameRepository.findOne(gameId);
            orderItem.setGame(game);
            orderItem.setQuantity(newOrder.getQuantities().get(i));
            orderItem.setOrder(order);
            orderItems.add(orderItem);
        }
        order.setPaymentByCreditCard(newOrder.isPaymentByCreditCard());
        Status status = new Status();
        order.setStatus(status);
        status.setOrder(order);
        order.setOrderItems(orderItems);
        orderRepository.save(order);
    }

    public void deleteOrder(int orderId) {
        orderRepository.delete(orderId);
    }
}
