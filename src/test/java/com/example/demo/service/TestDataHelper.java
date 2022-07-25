package com.example.demo.service;

import com.example.demo.dto.MovieDto;
import com.example.demo.model.Movie;

import java.util.List;
import java.util.Optional;


public class TestDataHelper {
    static List<Movie> allMovieListTest() {
        return List.of(
                new Movie("Iron Man", true, "Fantasy", 2008),
                new Movie("John Wick", false, "Thriller", 2014));
    }
    static Optional<Movie> optionalMovieTest() {
        return Optional.of(new Movie("John Wick", false, "Thriller", 2014));
    }
    static Optional<Movie> optionalMovieNegativeTest() {
        return Optional.empty();
    }
    static MovieDto movieDtoTest() {
        return new MovieDto("Batman", false, "Action", 2022);
    }
    static Movie movieTest() {
        return new Movie("Batman", false, "Action", 2022);
    }
}
