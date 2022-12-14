package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RegController {

    private UserService userService;


    public RegController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());

        return "registration";
    }
    @PostMapping("registration")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/oneUser";
    }


}