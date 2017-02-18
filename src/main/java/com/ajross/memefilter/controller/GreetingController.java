package com.ajross.memefilter.controller;

import com.ajross.memefilter.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by aross on 18/02/17.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World!") final String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}


