package com.example.demo.repo;

import com.example.demo.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class MovieRepositoryTests {
    @Autowired
    MovieRepo movieRepo;

    @Test
    public void findByNameRepositoryTest() {
        movieRepo.save(TestDataHelper.movieTest());
        Optional<Movie> found = movieRepo.findByName("Rocky");
        assertEquals(TestDataHelper.movieTest().getName(),found.get().getName());
    }

    @Test
    public void findMoviesByTopicRepositoryTest() {
        movieRepo.save(TestDataHelper.movieTest());
        List<Movie> found = movieRepo.findMoviesByTopic("Sport");
        assertEquals(TestDataHelper.movieTest().getTopic(),found.get(0).getTopic());
    }
}
