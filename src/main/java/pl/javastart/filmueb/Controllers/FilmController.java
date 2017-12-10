package pl.javastart.filmueb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.javastart.filmueb.model.Category;
import pl.javastart.filmueb.model.Movie;
import pl.javastart.filmueb.repositories.FilmRepository;

import java.util.List;

@Controller
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    private Category category;

    @GetMapping("/addmovieform")
    public String addMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movieinputform";
    }


    @GetMapping("/film")
    public String filmDetails(@RequestParam Long id, Model model) {
        Movie movie = filmRepository.findById(id);
        model.addAttribute("movie", movie);
        return "film";
    }


    @PostMapping("/addmovie")
    @ResponseBody
    public String addMovie(Movie movie) {
        List<Movie> movieList = filmRepository.getAllFilms();
        long maxId = 0;
        for (Movie movies : movieList) {
            if (movies.getId() > (int) maxId) {
                maxId = movies.getId();
            }
        }
        movie.setId(maxId + 1);
        filmRepository.addMovie(movie);


        return movie.toString() + "<br/> został dodany"; //tymczasowo
    }
}