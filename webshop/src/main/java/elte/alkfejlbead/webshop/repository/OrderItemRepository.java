package elte.alkfejlbead.webshop.repository;

import org.springframework.data.repository.CrudRepository;
import elte.alkfejlbead.webshop.entity.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
}
