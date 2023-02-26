package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService
{
    @Autowired
    MovieRepository movieRepository;
    public void addMovie (Movie movie) {movieRepository.saveMovies(movie);}

    public void addDirector (Director director) { movieRepository.saveDirector(director); }

    public void addDirectorCreatMovie (String movie, String director) {
        movieRepository.saveDirectorMoviePair(movie,director);
    }

    public Movie getMovies (String movie) {return movieRepository.findMovies(movie);}

    public Director getDirectors (String director) {return movieRepository.findDirector(director);}

    public List<String> getListOfMoviesFromDirector (String director) {
        return movieRepository.findMoviesFromDirector(director);
    }

    public List<String> getAllMovies () {return movieRepository.findAllMovies();}

    public void deleteDirectors (String director) {movieRepository.deleteDirector(director);}

    public void deleteAllDirectors() {movieRepository.deleteAllDirector();}
}

