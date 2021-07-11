package io.myservice.moviecatalogservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Test")
public class TEST {

    @GetMapping("/intest")
    public String func()
    {
        return "Hello Spring";
    }
}
