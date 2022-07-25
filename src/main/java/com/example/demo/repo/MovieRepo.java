package com.example.demo.repo;

import com.example.demo.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MovieRepo extends CrudRepository<Movie, Long> {
    Optional<Movie> findByName(String name);
    List<Movie> findMoviesByTopic(String topic);
}
