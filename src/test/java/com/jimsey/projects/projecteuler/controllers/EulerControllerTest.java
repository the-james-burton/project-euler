package com.jimsey.projects.projecteuler.controllers;

import com.jimsey.projects.projecteuler.services.EulerSolutionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = EulerController.class)
public class EulerControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private EulerSolutionService euler;

    @Test
    public void testSmoke() {

        given(euler.smoke()).willReturn(Flux.just(1L, 2L, 3L, 4L));

        webTestClient
                // Create a GET request to test an endpoint
                .get().uri("/euler/smoke")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Long.class)
                .hasSize(4)
                .contains(1L, 2L, 3L, 4L);

        verify(euler, times(1)).smoke();
    }
}

