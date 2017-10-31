package elte.alkfejlbead.webshop.repository;


import elte.alkfejlbead.webshop.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByRole(User.Role orderDate);
}