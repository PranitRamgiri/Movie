package com.chalabookkaru.movieservice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateMovieRequest {

    @NotBlank(message = "Please provide movie title")
    private String title;

    @Min(value = 1L, message = "Duration must be greater than 0 or less than 250 minutes")
    @Max(value = 250L, message = "Duration must be greater than 0 or less than 250 minutes")
    @NotNull(message = "Please provide movie duration")
    private Long duration;

    @NotBlank(message = "Please provide movie certificate")
    private String certificate;

    public String getTitle() {
        return title;
    }

    public Long getDuration() {
        return duration;
    }

    public String getCertificate() {
        return certificate;
    }
}
