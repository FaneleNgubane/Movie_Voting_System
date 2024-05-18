package com.movies.Movies.controller;

import com.movies.Movies.dto.MovieDto;
import com.movies.Movies.models.Movie;
import com.movies.Movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MovieController {

    private final JsonComponentModule jsonComponentModule;
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService, JsonComponentModule jsonComponentModule) {
        this.movieService = movieService;
        this.jsonComponentModule = jsonComponentModule;
    }


    @GetMapping("/movies")
    public String listMovies(Model model) {
        List<MovieDto> movies = movieService.findAllMovies();
        model.addAttribute("movies", movies);
        return "movies-list";
    }

    @GetMapping("/movies/new")
    public String createMovieForm(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "movies-create";
    }

    @PostMapping("/movies/new")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/movies/{movieId}/edit")
    public String editMovieForm(@PathVariable("movieId") long movieId, Model model) {
        MovieDto movie = movieService.findMovieById(movieId);
        model.addAttribute("movie", movie);
        return "movies-edit";
    }

    @PostMapping("/movies/{movieId}/edit")
    public String updateMovie(@PathVariable("movieId") long movieId, @ModelAttribute("movie") MovieDto movie) {
        movie.setId(movieId);
        movieService.updateMovie(movie);
        return "redirect:/movies";
    }
}