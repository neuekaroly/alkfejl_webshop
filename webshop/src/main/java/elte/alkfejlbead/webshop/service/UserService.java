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
        User dbUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(dbUser == null) {
            throw new UserNotValidException();
        }
        return new Token(dbUser.getToken());
    }

    public void register(User user) {
        user.setRole(User.Role.USER);
        user.setToken(UUID.randomUUID().toString());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    public void setCart(String cart, String token) throws UserNotValidException {
        User user = userRepository.findByToken(token);
        if (user == null) {
            throw new UserNotValidException();
        }
        user.setCart(cart);
    }

    public String getCart(String token) throws UserNotValidException {
        User user = userRepository.findByToken(token);
        if (user == null) {
            throw new UserNotValidException();
        }
        return user.getCart();
    }

}
