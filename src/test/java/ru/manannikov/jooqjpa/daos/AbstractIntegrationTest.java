package ru.manannikov.jooqjpa.daos;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

public abstract class AbstractIntegrationTest {
    private static String INIT_DIR = "/docker-entrypoint-initdb.d";

    protected static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17.4-bookworm");

    static {
        postgres.start();
    }

    @DynamicPropertySource
    protected static void configureProperties(
        DynamicPropertyRegistry registry
    ) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }
}