package com.astontech.dockerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication

public class DockerappApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerappApplication.class, args);
    }
}
