//package com.example.demo.repo;
//
//import com.example.demo.dto.MovieDto;
//import com.example.demo.model.Movie;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public  class MovieRepository {
//    private static int INDEX;
//    private List<Movie> movieList;
//
//    public List<Movie> findAll() {
//        return movieList;
//    }
//
//    public Optional<Movie> findById(int id) {
//        return movieList.stream().filter(movie -> movie.getId() == id).findFirst();
//    }
//
//    public void saveMovie(MovieDto movieDto) {
//        movieList.add(new Movie(++INDEX, movieDto.getName(), movieDto.isLegal(), movieDto.getTopic(), movieDto.getYear()));
//    }
//
//    @PostConstruct
//    public void postConstruct(){
//        movieList = new ArrayList<>();
//
//        movieList.add(new Movie(++INDEX, "Iron Man", true, "Fantasy", 2008));
//        movieList.add(new Movie(++INDEX, "Sonic the Hedgehog", false, "Fantasy", 2020));
//        movieList.add(new Movie(++INDEX, "Doctor Strange", true, "Fantasy", 2016));
//        movieList.add(new Movie(++INDEX, "Rocky", false, "Sport", 1976));
//        movieList.add(new Movie(++INDEX, "The Karate Kid", true, "Sport", 2010));
//        movieList.add(new Movie(++INDEX, "Batman", false, "Action", 2022));
//        movieList.add(new Movie(++INDEX, "Thor: Ragnarok", true, "Action", 2017));
//        movieList.add(new Movie(++INDEX, "Captain Marvel", false, "Action", 2019));
//        movieList.add(new Movie(++INDEX, "Red notice", true, "Thriller", 2021));
//        movieList.add(new Movie(++INDEX, "John Wick", false, "Thriller", 2014));
//        movieList.add(new Movie(++INDEX, "Harry Potter and the Sorcerer's Stone", true, "Adventure", 2001));
//        movieList.add(new Movie(++INDEX, "Harry Potter and the Chamber of Secrets", false, "Adventure", 2002));
//        movieList.add(new Movie(++INDEX, "Harry Potter and the Prisoner of Azkaban", true, "Adventure", 2004));
//    }
//}
