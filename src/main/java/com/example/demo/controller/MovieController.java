package com.example.demo.controller;

import com.example.demo.dto.MovieDto;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Validated
@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public List<MovieDto> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public MovieDto findById(@PathVariable("id") @Min(1) long id) {
            return movieService.findById(id);
    }

    @GetMapping(value = "/by-topic", params = "topic")
    public List<MovieDto> findMoviesByTopic(@RequestParam("topic") @NotBlank String topic) {
        return movieService.findMoviesByTopic(topic);
    }

    @GetMapping(value = "/is-legal", params = "legal")
    public List<MovieDto> findMoviesIsLegal(@RequestParam("legal") @NotNull boolean isLegal) {
        return movieService.findMoviesIsLegal(isLegal);
    }

    @GetMapping(value = "/before-year", params = "year")
    public List<MovieDto> findMoviesBeforeYear(@RequestParam("year") @NotNull int year) {
        return movieService.findMoviesBeforeYear(year);
    }

    @PostMapping(value = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody MovieDto movieDto) {
        movieService.save(movieDto);
    }
}
