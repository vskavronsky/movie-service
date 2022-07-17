package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
public class MovieDto {

    @NotNull
    private String name;

    @NotNull
    private boolean legal;

    @NotNull
    private String topic;

    @NotNull
    @Min(value = 1884, message = "Should be 1884 or greater!")
    private int year;
}
