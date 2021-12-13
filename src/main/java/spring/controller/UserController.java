package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.dao.UserDao;
import spring.model.User;
import spring.servise.UserServise;

import java.util.List;

@Controller
public class UserController {
  private final UserServise userServise;

    public UserController(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping("/")
    public String showAllUser(Model model) {
        List<User> allUsers = userServise.listUsers();
        model.addAttribute("allUser",allUsers);
        return "allUser";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userServise.saveUser(user);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServise.getById(id));
        return "edit-user";
    }

    @PatchMapping("/edit/{id}")
    public String editUser(@ModelAttribute User user) {
        userServise.update(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userServise.delete(id);
        return "redirect:/";
    }


}
