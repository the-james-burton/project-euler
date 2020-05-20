package com.jimsey.projects.projecteuler.clients;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class EulerWebClient {
    private final WebClient client = WebClient.create("http://localhost:8080");

    public Flux<Long> smoke() {
        return client.get()
                .uri("/euler/smoke")
                .retrieve()
                .bodyToFlux(Long.class);
    }

}