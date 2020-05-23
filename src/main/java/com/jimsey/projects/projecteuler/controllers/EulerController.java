package com.jimsey.projects.projecteuler.controllers;

import com.jimsey.projects.projecteuler.services.EulerSolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/euler")
public class EulerController {

    @Autowired
    EulerSolutionService euler;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/smoke", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Long> smoke() {
        return euler.smoke();
    }

    @GetMapping("/{id}")
    public Flux<Long> solve() {
        return euler.smoke();
    }

}
