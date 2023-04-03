package com.example.PP3_1_1.controller;

import com.example.PP3_1_1.model.User;
import com.example.PP3_1_1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "users";
    }
    @GetMapping("/add")
    public String addUserFrom(User user) {
        return "add";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserFrom(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserId(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }
}
