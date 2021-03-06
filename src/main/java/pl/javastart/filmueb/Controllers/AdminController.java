package pl.javastart.filmueb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.javastart.filmueb.model.User;
import pl.javastart.filmueb.model.UserRole;
import pl.javastart.filmueb.repositories.RoleRepository;
import pl.javastart.filmueb.repositories.UserRepository;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("")
    public String admin(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "admin";
    }
    @PostMapping("/changerole")
    private String changeRole(@RequestParam String username,
                              @RequestParam String role){
        User user = userRepository.findByUsername(username);
        user.setRole(role);
        userRepository.save(user);
        return "admin";
    }
}