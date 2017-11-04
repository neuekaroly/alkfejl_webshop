package elte.alkfejlbead.webshop.repository;

import elte.alkfejlbead.webshop.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends CrudRepository<OrderItem, Long> {
}
