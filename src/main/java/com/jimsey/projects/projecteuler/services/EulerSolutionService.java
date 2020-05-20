package com.jimsey.projects.projecteuler.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class EulerSolutionService {

    public Flux<Long> smoke() {
        return Flux.just(1L, 2L, 3L, 4L).delayElements(Duration.ofSeconds(1));
    }
}
