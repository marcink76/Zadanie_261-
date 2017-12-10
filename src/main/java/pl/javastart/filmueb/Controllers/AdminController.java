package pl.javastart.filmueb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.javastart.filmueb.model.User;
import pl.javastart.filmueb.model.UserRole;
import pl.javastart.filmueb.repositories.RoleRepository;
import pl.javastart.filmueb.repositories.UserRepository;

import java.util.List;


@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/admin")
    public String admin(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);

        return "admin";
    }
    @PostMapping("/admin/changerole")
    private String changeRole(@RequestParam String username,
                              @RequestParam String role){
        UserRole userRole =  roleRepository.findByUsername(username);
        userRole.setRole(role);
        roleRepository.save(userRole);
        return "admin";
    }
}