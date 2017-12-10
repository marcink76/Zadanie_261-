package pl.javastart.filmueb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.javastart.filmueb.model.User;
import pl.javastart.filmueb.repositories.RoleRepository;
import pl.javastart.filmueb.repositories.UserRepository;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/adduser")
    public String register(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pass", "pass");
        return "registrationform";
    }

    @PostMapping("/adduser1")
    public String registration(User user){

        user.setEnabled(true);
        user.setRole("ROLE_USER");
        userRepository.save(user);

        return "redirect:/index";
    }
}