package pl.javastart.filmueb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.filmueb.model.User;

@Controller
public class RegistrationController {
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pass", "pass");
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(User user){
        return user.toString();

    }

}
