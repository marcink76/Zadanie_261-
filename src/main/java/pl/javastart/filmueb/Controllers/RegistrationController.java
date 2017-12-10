package pl.javastart.filmueb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.filmueb.model.User;
import pl.javastart.filmueb.repositories.RoleRepository;
import pl.javastart.filmueb.repositories.UserRepository;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pass", "pass");
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(User user){

        user.setEnabled(true);
        userRepository.save(user);

        return "redirect:login";
    }
}