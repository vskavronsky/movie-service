package com.example.demo.controlller;

import com.example.demo.model.Movie;

public class TestDataHelper {
    static Movie createTestMovie() {
        return new Movie("Iron Man", true, "Fantasy", 2008);
    }
    static Movie createInvalidTestMovie() {
        return new Movie("Wrong", true, "Fantasy", 1668);
    }
}
