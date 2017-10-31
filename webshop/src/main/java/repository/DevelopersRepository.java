package repository;

import org.springframework.data.repository.CrudRepository;
import entity.OrderDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopersRepository extends CrudRepository<OrderDetails, Long> {


}