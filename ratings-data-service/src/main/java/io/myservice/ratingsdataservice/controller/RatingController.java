package io.myservice.ratingsdataservice.controller;

import io.myservice.ratingsdataservice.models.Rating;
import io.myservice.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {

    @RequestMapping("/{movieId}")
    public UserRating getuserRating(@PathVariable("movieId") String Id)
    {
        List<Rating> ratings= Arrays.asList(
                new Rating("1234",4),
                new Rating("5678",5)
        );
        UserRating userRating=new UserRating();
        userRating.setUserRating(ratings);
        return userRating;

    }
}
