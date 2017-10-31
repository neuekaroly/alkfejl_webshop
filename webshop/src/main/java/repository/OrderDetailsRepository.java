package repository;

import org.springframework.data.repository.CrudRepository;
import entity.OrderDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long> {
    List<OrderDetails> findAllByOrderStatus(String country);


}