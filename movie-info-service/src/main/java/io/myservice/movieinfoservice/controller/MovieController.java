package io.myservice.movieinfoservice.controller;

import io.myservice.movieinfoservice.models.Movie;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId)
    {
        return new Movie("1234","Money Heist","CHORI");
    }

    @GetMapping("/getmovies")
    public List<Movie> getMovieList()
    {
        List<Movie> movies=new ArrayList<Movie>();
        movies.add(new Movie("1234","Dark Knight","cgfcgf"));
        movies.add(new Movie("5678","TransFormer","ytyu"));
        return movies;
    }
}
