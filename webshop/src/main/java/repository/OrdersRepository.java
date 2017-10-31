package repository;

import entity.Orders;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long>{
    List<Orders> findAllByIsDone(boolean isDone);
    List<Orders> findAllByPaymentByCreditCard(boolean paymentByCreditCard);
    List<Orders> findAllByOrderDate(String orderDate);
}
