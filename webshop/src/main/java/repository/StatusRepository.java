package repository;

import entity.Orders;
import entity.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long>{
    List<Status> findAllByOrderStatus(Status.OrderStatus orderStatus);
    List<Status> findAllByShippingStatus(Status.ShippingStatus shippingStatus);
}
