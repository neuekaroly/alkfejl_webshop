package elte.alkfejlbead.webshop.repository;


import elte.alkfejlbead.webshop.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAllByRole(User.Role orderDate);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    User findByToken(String token);
}