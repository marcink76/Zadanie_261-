package pl.javastart.filmueb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.filmueb.model.Movie;
import pl.javastart.filmueb.model.User;
import pl.javastart.filmueb.repositories.FilmRepository;
import pl.javastart.filmueb.repositories.UserRepository;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String filmDetails(Model model, Principal principal) {
        String currentUserName = principal.getName();
        User user = userRepository.findByUsername(currentUserName);

        List<Movie> allMovies = filmRepository.getAllFilms();
        model.addAttribute("lista", allMovies);
        model.addAttribute("role", user.getRole());
        return "index";
    }
}
