package elte.alkfejlbead.webshop.repository;

import elte.alkfejlbead.webshop.entity.Orders;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long>{

}
