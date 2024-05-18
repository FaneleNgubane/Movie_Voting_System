package com.movies.Movies.service.impl;

import com.movies.Movies.dto.MovieDto;
import com.movies.Movies.models.Movie;
import com.movies.Movies.repository.Movierepository;
import com.movies.Movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceimpl implements MovieService {

    private Movierepository movieRepository;

    @Autowired
    public MovieServiceimpl(Movierepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDto> findAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map((movie) -> mapToMovieDto(movie)).collect(Collectors.toList());
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public MovieDto findMovieById(long movieId) {
        Movie movie = movieRepository.findById(movieId).get();
        return mapToMovieDto(movie);
    }

    @Override
    public void updateMovie(MovieDto movieDto) {
        Movie movie = mapToMovie(movieDto);
        movieRepository.save(movie);
    }

    private Movie mapToMovie(MovieDto movie) {
        Movie movieDto = Movie.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .PhotoUrl(movie.getPhotoUrl())
                .content(movie.getContent())
                .createdOn(movie.getCreatedOn())
                .updatedOn(movie.getUpdatedOn())
                .build();
        return movieDto;
    }

    private MovieDto mapToMovieDto(Movie movie) {
        MovieDto movieDto = MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .PhotoUrl(movie.getPhotoUrl())
                .content(movie.getContent())
                .createdOn(movie.getCreatedOn())
                .updatedOn(movie.getUpdatedOn())
                .build();
        return movieDto;
    }
}