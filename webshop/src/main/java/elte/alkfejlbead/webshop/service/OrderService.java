package elte.alkfejlbead.webshop.service;

import elte.alkfejlbead.webshop.entity.*;
import elte.alkfejlbead.webshop.model.api.request.NewOrderDTO;
import elte.alkfejlbead.webshop.model.api.response.Token;
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

    public void addNewOrder(NewOrderDTO newOrder, String token) {
        User user = userRepository.findByToken(token);
        List<OrderItem> orderItems = new ArrayList<>();
        Order order = new Order();
        order.setOrderDate(Calendar.getInstance().getTime());
        order.setDone(false);
        order.setUser(user);
        ArrayList<OrderItem> newOrderItems = new ArrayList<>();

        for(int i = 0; i < newOrder.getOrderItems().size(); i++) {
            OrderItem newOrderItem = new OrderItem();
            newOrderItem.setGame(gameRepository.findOne(newOrder.getOrderItems().get(i).getGameId()));
            newOrderItem.setQuantity(newOrder.getOrderItems().get(i).getQuantity());
            newOrderItems.add(newOrderItem);
            newOrderItem.setOrder(order);
        }
        order.setOrderItems(newOrderItems);
        order.setPaymentByCreditCard(newOrder.isPaymentByCreditCard());
        Status status = new Status();
        order.setStatus(status);
        status.setOrder(order);
        order.setOrderPrice(newOrder.getOrderPrice());
        orderRepository.save(order);
    }

    public void deleteOrder(int orderId) {
        orderRepository.delete(orderId);
    }
}
