package com.movies.Movies.controller;

import com.movies.Movies.dto.MovieDto;
import com.movies.Movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/movies")
    public String listMovies(Model model) {
        List<MovieDto> movies = movieService.findAllMovies();
        model.addAttribute("movies", movies);
        return "movies-list";
    }
}