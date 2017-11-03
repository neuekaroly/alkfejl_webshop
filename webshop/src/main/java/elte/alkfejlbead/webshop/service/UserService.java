package elte.alkfejlbead.webshop.service;

import elte.alkfejlbead.webshop.entity.User;
import elte.alkfejlbead.webshop.repository.UserRepository;
import elte.alkfejlbead.webshop.service.Exceptions.UserNotValidException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
@Data
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private User user;

    public User login(User user) throws UserNotValidException {
        if (isValid(user)) {
            return this.user = userRepository.findByUsername(user.getUsername()).get();
        }
        throw new UserNotValidException();
    }

    public User register(User user) {
        user.setRole(User.Role.USER);
        this.user = userRepository.save(user);
        return user;
    }

    public boolean isValid(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).isPresent();
    }

    public boolean isLoggedIn() {
        return user != null;
    }

}
