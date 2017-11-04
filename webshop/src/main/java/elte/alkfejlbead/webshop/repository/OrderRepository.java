package elte.alkfejlbead.webshop.repository;

import elte.alkfejlbead.webshop.entity.Order;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
    List<Order> findAllByIsDone(boolean isDone);

    List<Order> findAllByPaymentByCreditCard(boolean paymentByCreditCard);

    List<Order> findAllByOrderDate(String orderDate);
}
