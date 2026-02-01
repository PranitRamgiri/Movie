package com.chalabookkaru.movieservice.service;

import com.chalabookkaru.movieservice.dto.CreateMovieRequest;
import com.chalabookkaru.movieservice.dto.MovieResponse;
import com.chalabookkaru.movieservice.entity.Movie;
import com.chalabookkaru.movieservice.exception.MovieAlreadyExistsException;
import com.chalabookkaru.movieservice.exception.MovieNotFoundException;
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
            throw new MovieAlreadyExistsException("Please enter new Movie title this one we already have", HttpStatus.CONFLICT);
        }

        Movie movieToSave = new Movie();
        movieToSave.setTitle(createMovieRequest.getTitle());
        movieToSave.setDuration(createMovieRequest.getDuration().intValue());
        movieToSave.setCertificate(createMovieRequest.getCertificate());
        Movie savedMovie = movieRepository.save(movieToSave);

        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setMovieId(savedMovie.getId());
        movieResponse.setTitle(savedMovie.getTitle());
        movieResponse.setDuration(savedMovie.getDuration());
        movieResponse.setCertificate(savedMovie.getCertificate());
        return movieResponse;
    }

    @Override
    public MovieResponse getMovieByTitle(String title) {
        Movie movie = movieRepository.findByTitle(title).orElseThrow(
                () -> new MovieNotFoundException("Movie not found, please enter valid movie title", HttpStatus.NOT_FOUND)
        );
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setMovieId(movie.getId());
        movieResponse.setTitle(movie.getTitle());
        movieResponse.setDuration(movie.getDuration());
        movieResponse.setCertificate(movie.getCertificate());
        return movieResponse;
    }

    @Override
    public MovieResponse getMovieById(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new MovieNotFoundException("Movie not exists", HttpStatus.NOT_FOUND)
        );
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setMovieId(movie.getId());
        movieResponse.setTitle(movie.getTitle());
        movieResponse.setDuration(movie.getDuration());
        movieResponse.setCertificate(movie.getCertificate());
        return movieResponse;
    }
}
