package com.example.demo.service;

import com.example.demo.dto.MovieDto;
import com.example.demo.exception.MovieNotFoundException;
import com.example.demo.repo.MovieRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MovieServiceTests {
    @Mock
    MovieRepo movieRepository;
    @InjectMocks
    MovieService movieService;

    @Test
    public void findAllServiceTest() {
        when(movieRepository.findAll()).thenReturn(TestDataHelper.allMovieListTest());

        List<MovieDto> movieDtoList = movieService.findAll();

        assertEquals(2, movieDtoList.size());
    }

    @Test
    public void findByIdServiceTest() {
        when(movieRepository.findById(2L)).thenReturn(TestDataHelper.optionalMovieTest());

        MovieDto movieDto = movieService.findById(2);

        assertEquals("John Wick", movieDto.getName());
        assertFalse(movieDto.isLegal());
        assertEquals("Thriller", movieDto.getTopic());
        assertEquals(2014, movieDto.getYear());
    }

    @Test
    public void findByIdServiceNegativeTest() {
        when(movieRepository.findById(99L)).thenReturn(TestDataHelper.optionalMovieNegativeTest());

        Throwable ex = assertThrows(MovieNotFoundException.class, () -> movieService.findById(99));
        assertEquals("No item with such id!", ex.getLocalizedMessage());
    }

    @Test
    public void findAllByTopicServiceTest() {
        when(movieRepository.findMoviesByTopic("Fantasy")).thenReturn(TestDataHelper.allMovieByTopic());

        List<MovieDto> movieDtoList = movieService.findMoviesByTopic("Fantasy");

        assertEquals(2, movieDtoList.size());
        assertEquals("Iron Man", movieDtoList.get(0).getName());
        assertTrue(movieDtoList.get(0).isLegal());
        assertEquals("Fantasy", movieDtoList.get(0).getTopic());
        assertEquals(2008, movieDtoList.get(0).getYear());
    }

    @Test
    public void findAllIsLegalServiceTest() {
        when(movieRepository.findAll()).thenReturn(TestDataHelper.allMovieListTest());

        List<MovieDto> movieDtoList = movieService.findMoviesIsLegal(false);

        assertEquals(1, movieDtoList.size());
        assertEquals("John Wick", movieDtoList.get(0).getName());
        assertFalse(movieDtoList.get(0).isLegal());
        assertEquals("Thriller", movieDtoList.get(0).getTopic());
        assertEquals(2014, movieDtoList.get(0).getYear());
    }

    @Test
    public void findAllBeforeYearServiceTest() {
        when(movieRepository.findAll()).thenReturn(TestDataHelper.allMovieListTest());

        List<MovieDto> movieDtoList = movieService.findMoviesBeforeYear(2014);

        assertEquals(1, movieDtoList.size());
        assertEquals("Iron Man", movieDtoList.get(0).getName());
        assertTrue(movieDtoList.get(0).isLegal());
        assertEquals("Fantasy", movieDtoList.get(0).getTopic());
        assertEquals(2008, movieDtoList.get(0).getYear());
    }

    @Test
    public void saveMovieServiceTest() {
        movieService.save(TestDataHelper.movieDtoTest());

        verify(movieRepository, times(1)).save(TestDataHelper.movieTest());
    }
}
