package io.myservice.moviecatalogservice.controller;

import io.myservice.moviecatalogservice.models.CatalogItem;
import io.myservice.moviecatalogservice.models.Movie;
import io.myservice.moviecatalogservice.models.Rating;
import io.myservice.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogServiceController
{

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
    {
        List<CatalogItem> cl=new ArrayList<>();

        UserRating ratings=restTemplate.getForObject("http://ratings-data-service/ratingsdata/"+userId,UserRating.class);
        List<Rating> r= ratings.getUserRating();
        for(Rating ratings1: r)
        {
            Movie movies=restTemplate.getForObject("http://movie-info-service/movies/"+userId,Movie.class);
            cl.add(new CatalogItem(movies.getName(), movies.getDesc(),ratings1.getRating()));
        }
        return cl;
    }
}
