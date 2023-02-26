package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController
{
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie (@RequestBody Movie movies)
    {
        movieService.addMovie(movies);
        return new ResponseEntity<>("New Movie Added Successfully", HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector (@RequestBody Director director)
    {
        movieService.addDirector(director);

        return new ResponseEntity<>("NEW DIRECTOR ADDED SUCCESSFULLY", HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("q") String movies, @RequestParam("q1") String director)
    {
        movieService.addDirectorCreatMovie(movies,director);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movie)
    {
        Movie movieList = movieService.getMovies(movie);

        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName (@PathVariable("name") String director)
    {
        Director directorList = movieService.getDirectors(director);

        return new ResponseEntity<>(directorList, HttpStatus.OK);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String director)
    {
        List<String> movieList_director = movieService.getListOfMoviesFromDirector(director);

        return new ResponseEntity<>(movieList_director, HttpStatus.OK);
    }


    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies()
    {
        List<String> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }


    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("d") String director)
    {
        movieService.deleteDirectors(director);

        return new ResponseEntity<>(director + " deleted Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        movieService.deleteAllDirectors();

        return new ResponseEntity<>("All Directors Deleted Successfully", HttpStatus.FOUND);
    }
}




