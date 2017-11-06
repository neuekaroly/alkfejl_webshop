package elte.alkfejlbead.webshop.controller;

import elte.alkfejlbead.webshop.entity.User;
import elte.alkfejlbead.webshop.model.api.response.Token;
import elte.alkfejlbead.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/greet")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute(new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        if (userService.isValid(user)) {
            return redirectToGreeting(user);
        }
        model.addAttribute("loginFailed", true);
        return "login";
    }

    @PostMapping("/register")
    public Token register(@RequestBody User user) {
       return userService.register(user);
    }

    private String redirectToGreeting(@ModelAttribute User user) {
        return "redirect:/users/greet?name=" + user.getUsername();
    }
}