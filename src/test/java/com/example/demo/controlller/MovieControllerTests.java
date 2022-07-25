package com.example.demo.controlller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTests {
    private final MockMvc mockMvc;

    @Autowired
    public MovieControllerTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void findAllMoviesControllerTest() throws Exception {
        mockMvc.perform(get("/movies")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdControllerTest() throws Exception {
        mockMvc.perform(get("/movies/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdControllerNegativeTest() throws Exception {
        mockMvc.perform(get("/movies/99")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void findAllByTopicControllerTest() throws Exception {
        mockMvc.perform(get("/movies/by-topic?topic=Sport")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findAllIsLegalControllerTest() throws Exception {
        mockMvc.perform(get("/movies/is-legal?legal=true")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findAllBeforeYearControllerTest() throws Exception {
        mockMvc.perform(get("/movies/before-year?year=2020")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void saveMovieControllerTest() throws Exception {
        mockMvc.perform(post("/movies/new")
                        .content(UtilityHelper.asJsonString(TestDataHelper.createTestMovie()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void saveMovieControllerNegativeTest() throws Exception {
        mockMvc.perform(post("/movies/new")
                        .content(UtilityHelper.asJsonString(TestDataHelper.createInvalidTestMovie()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
