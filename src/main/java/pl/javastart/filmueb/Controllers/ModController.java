package pl.javastart.filmueb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.filmueb.model.User;
import pl.javastart.filmueb.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/moderator")
public class ModController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String admin(Model model) {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_MODERATOR");
        roles.add("ROLE_USER");
        List<User> userList = userRepository.getAllByRoleIn(roles);

        model.addAttribute("userList", userList);
        return "moderator";
    }

    @PostMapping("/changerole")
    private String changeRole(@RequestParam String username,
                              @RequestParam String role) {
        User user = userRepository.findByUsername(username);
        user.setRole(role);
        userRepository.save(user);
        return "moderator";
    }

}
