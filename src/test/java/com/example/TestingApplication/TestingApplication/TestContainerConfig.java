package com.example.TestingApplication.TestingApplication;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;


@TestConfiguration
public class TestContainerConfig {
    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer(){
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
    }
}