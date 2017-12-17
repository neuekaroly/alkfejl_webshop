package elte.alkfejlbead.webshop.controller;

import elte.alkfejlbead.webshop.annotation.Role;
import elte.alkfejlbead.webshop.entity.User;
import elte.alkfejlbead.webshop.model.api.response.Token;
import elte.alkfejlbead.webshop.service.Exceptions.UserNotValidException;
import elte.alkfejlbead.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Role()
    @PostMapping("/login")
    public Token login(HttpServletRequest request, @RequestBody User user) throws UserNotValidException {
       return userService.login(user);
    }

    @Role()
    @PostMapping("/register")
    public void register(HttpServletRequest request, @RequestBody User user) {
       userService.register(user);
    }

    @Role(User.Role.USER)
    @PostMapping("/cart")
    public void addCart(HttpServletRequest request, @RequestBody String cart) throws UserNotValidException {
        userService.setCart(request.getHeader(Token.TOKEN),cart);
    }

    @Role(User.Role.USER)
    @GetMapping("/cart")
    public String getCart(HttpServletRequest request) throws UserNotValidException {
       return userService.getCart(request.getHeader(Token.TOKEN));
    }

    @Role(User.Role.ADMIN)
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }
}