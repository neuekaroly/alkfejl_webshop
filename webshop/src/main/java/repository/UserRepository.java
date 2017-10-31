package repository;

import entity.Orders;
import entity.Status;
import entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Status, Long> {
    List<Users> findAllByRole(Users.Role orderDate);
}
