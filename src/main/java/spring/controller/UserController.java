package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.dao.UserDao;
import spring.model.User;
import spring.servise.UserServise;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
  private final UserServise userServise;

    @Autowired
    public UserController(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("allUs",userServise.allUsers());
        return "all-user";
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
    public String update(@ModelAttribute("user") User user,
                           @PathVariable("id") int id) {
        userServise.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userServise.delete(id);
        return "redirect:/";
    }


}
