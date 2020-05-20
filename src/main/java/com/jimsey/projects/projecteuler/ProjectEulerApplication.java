package com.jimsey.projects.projecteuler;

import com.jimsey.projects.projecteuler.clients.EulerWebClient;
import com.jimsey.projects.projecteuler.services.EulerSolutionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.lang.invoke.MethodHandles;

@SpringBootApplication
@EnableWebFlux
public class ProjectEulerApplication {

	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(ProjectEulerApplication.class, args);

		EulerWebClient ewc = new EulerWebClient();
		ewc.smoke().subscribe(item -> log.info("smoke:{}", item));

		EulerSolutionService euler = app.getBean(EulerSolutionService.class);
		euler.smoke().subscribe(item -> log.info("service:{}", item));
	}

}
