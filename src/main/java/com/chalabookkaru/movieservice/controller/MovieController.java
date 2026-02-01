package com.chalabookkaru.movieservice.controller;

import com.chalabookkaru.movieservice.dto.CreateMovieRequest;
import com.chalabookkaru.movieservice.dto.MovieResponse;
import com.chalabookkaru.movieservice.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/createMovie")
    public ResponseEntity<MovieResponse> createMovie(@Valid @RequestBody CreateMovieRequest createMovieRequest) {
        MovieResponse response = movieService.createMovie(createMovieRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<MovieResponse> getMovie(@PathVariable String title) {
        MovieResponse response = movieService.getMovieByTitle(title);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Long movieId) {
        MovieResponse response = movieService.getMovieById(movieId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
