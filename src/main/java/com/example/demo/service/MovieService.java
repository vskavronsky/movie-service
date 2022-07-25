package com.example.demo.service;

import com.example.demo.dto.MovieDto;
import com.example.demo.exception.MovieNotFoundException;
import com.example.demo.model.Movie;
import com.example.demo.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MovieService {
    private static final String EX_MESSAGE = "No item with such id!";
    private final MovieRepo movieRepo;

    @Autowired
    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public List<MovieDto> findAll() {
        List<Movie> movieList = new ArrayList<>();
        movieRepo.findAll().forEach(movieList::add);

        return movieList.stream()
                .map(movie -> new MovieDto(movie.getName(), movie.isLegal(), movie.getTopic(), movie.getYear()))
                .collect(Collectors.toList());
    }

    public MovieDto findById(long id) {
        Movie movie = movieRepo.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(EX_MESSAGE));

        return new MovieDto(movie.getName(), movie.isLegal(), movie.getTopic(), movie.getYear());
    }

    public List<MovieDto> findMoviesByTopic(String topic) {
        List<Movie> movieList = movieRepo.findMoviesByTopic(topic);

        return movieList.stream()
                .map(movie -> new MovieDto(movie.getName(), movie.isLegal(), movie.getTopic(), movie.getYear()))
                .collect(Collectors.toList());
    }

    public List<MovieDto> findMoviesIsLegal(boolean isLegal) {
        List<Movie> movieList = new ArrayList<>();
        movieRepo.findAll().forEach(movieList::add);

        return movieList.stream()
                .filter(movie -> movie.isLegal() == isLegal)
                .map(movie -> new MovieDto(movie.getName(), movie.isLegal(), movie.getTopic(), movie.getYear()))
                .collect(Collectors.toList());
    }

    public List<MovieDto> findMoviesBeforeYear(int year) {
        List<Movie> movieList = new ArrayList<>();
        movieRepo.findAll().forEach(movieList::add);

        return movieList.stream()
                .filter(movie -> movie.getYear() < year)
                .map(movie -> new MovieDto(movie.getName(), movie.isLegal(), movie.getTopic(), movie.getYear()))
                .collect(Collectors.toList());
    }

    public void save(MovieDto movieDto) {
        movieRepo.save(new Movie(movieDto.getName(), movieDto.isLegal(), movieDto.getTopic(), movieDto.getYear()));
    }
}
