package openEvents.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRoute {
    @GetMapping(value="/hello",produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello(){
       return "{\"hello\":\"This is a test spring application\"}" ;
    }
}
