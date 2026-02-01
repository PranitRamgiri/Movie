package com.chalabookkaru.movieservice.service;

import com.chalabookkaru.movieservice.dto.CreateMovieRequest;
import com.chalabookkaru.movieservice.dto.MovieResponse;

public interface MovieService {

    MovieResponse createMovie(CreateMovieRequest createMovieRequest);

    MovieResponse getMovieByTitle(String title);

    MovieResponse getMovieById(Long movieId);
}
