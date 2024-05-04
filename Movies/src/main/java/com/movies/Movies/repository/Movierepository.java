package com.movies.Movies.repository;

import com.movies.Movies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Movierepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findMovieById(Long id);
}
