package com.movies.Movies.service;

import com.movies.Movies.dto.MovieDto;
import com.movies.Movies.models.Movie;

import java.util.List;

public interface MovieService {
    List<MovieDto> findAllMovies();
    Movie saveMovie(Movie movie);
}
