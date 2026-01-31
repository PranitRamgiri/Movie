package com.chalabookkaru.movieservice.service;

import com.chalabookkaru.movieservice.dto.CreateMovieRequest;
import com.chalabookkaru.movieservice.dto.MovieResponse;
import com.chalabookkaru.movieservice.entity.Movie;
import com.chalabookkaru.movieservice.exception.MovieException;
import com.chalabookkaru.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieResponse createMovie(CreateMovieRequest createMovieRequest) {

        Optional<Movie> movieOptional = movieRepository.findByTitle(createMovieRequest.getTitle());
        if (movieOptional.isPresent()) {
            throw new MovieException("Please enter new Movie title this one we already have", HttpStatus.CONFLICT);
        }

        Movie movieToSave = new Movie();
        movieToSave.setTitle(createMovieRequest.getTitle());
        movieToSave.setDuration(createMovieRequest.getDuration().intValue());
        movieToSave.setCertificate(createMovieRequest.getCertificate());
        Movie savedMovie = movieRepository.save(movieToSave);

        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setMovieTitle(savedMovie.getTitle());
        movieResponse.setMessage("Movie saved successfully");
        return movieResponse;
    }

    @Override
    public MovieResponse getMovieByTitle(String title) {
        Optional<Movie> movieOptional = movieRepository.findByTitle(title);
        if (movieOptional.isEmpty()) {
            throw new MovieException("Movie not found, please enter valid movie title", HttpStatus.NOT_FOUND);
        }
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setMovieTitle(movieOptional.get().getTitle());
        movieResponse.setMessage("Movie found successfully");
        return movieResponse;
    }
}
