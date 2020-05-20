package com.jimsey.projects.projecteuler.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class EulerRouter {

    @Bean
    public RouterFunction<ServerResponse> route() {

        return RouterFunctions
                .route(GET("/hello"), req -> ok()
                        .body(Mono.just("hello to you!"), String.class))
                .andRoute(GET("/hi"), req -> ok()
                        .contentType(MediaType.TEXT_EVENT_STREAM)
                        .body(Flux.just("one", "two", "three", "four").delayElements(Duration.ofSeconds(1)), String.class));
    }
}