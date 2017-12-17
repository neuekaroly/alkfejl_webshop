package elte.alkfejlbead.webshop.service;

import com.fasterxml.jackson.annotation.JsonRawValue;
import elte.alkfejlbead.webshop.entity.User;
import elte.alkfejlbead.webshop.model.api.response.Token;
import elte.alkfejlbead.webshop.repository.UserRepository;
import elte.alkfejlbead.webshop.service.Exceptions.UserNotValidException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

@Service
@SessionScope
@Data
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Token login(User user) throws UserNotValidException {
        User dbUser = userRepository.findByUsername(user.getUsername());
        if(dbUser == null || !new BCryptPasswordEncoder().matches(user.getPassword(), dbUser.getPassword())) {
            throw new UserNotValidException();
        }
        return new Token(dbUser.getToken(), dbUser.getRole());
    }

    public void register(User user) {
        user.setRole(User.Role.USER);
        user.setToken(UUID.randomUUID().toString());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    public void setCart(String token, String cart) throws UserNotValidException {
        User user = userRepository.findByToken(token);
        if (user == null) {
            throw new UserNotValidException();
        }
        user.setCart(cart);
        userRepository.save(user);
    }

    public String getCart(String token) throws UserNotValidException {
        User user = userRepository.findByToken(token);
        if (user == null) {
            throw new UserNotValidException();
        }
        return user.getCart();
    }

    public void deleteUser(int useId) {
        userRepository.delete(useId);
    }

}
