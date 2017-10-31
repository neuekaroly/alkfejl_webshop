package elte.alkfejlbead.webshop.repository;

import elte.alkfejlbead.webshop.entity.OrderDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopersRepository extends CrudRepository<OrderDetails, Long> {


}
