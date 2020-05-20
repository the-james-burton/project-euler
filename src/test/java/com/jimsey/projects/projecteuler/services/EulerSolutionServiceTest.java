package com.jimsey.projects.projecteuler.services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.time.Duration;

public class EulerSolutionServiceTest {

    final EulerSolutionService euler = new EulerSolutionService();

    @Test
    public void testSmoke() {
        StepVerifier
                .withVirtualTime(euler::smoke)
                .thenAwait(Duration.ofSeconds(1))
                .expectNext(1L)
                .thenAwait(Duration.ofSeconds(1))
                .expectNext(2L)
                .thenAwait(Duration.ofSeconds(1))
                .expectNext(3L)
                .thenAwait(Duration.ofSeconds(1))
                .expectNext(4L)
                .expectComplete()
                .verify();
    }
}
