package com.movies.Movies.service;

import com.movies.Movies.dto.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> findAllMovies();
}
