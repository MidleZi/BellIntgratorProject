package ru.bellintegrator.myproject;

import org.junit.Test;
import org.springframework.boot.SpringApplication;

public class MyApplicationTest {

    @Test
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyApplication.class);
        app.run(args);
    }

    @Test
    public void controllerPool() {
    }

    @Test
    public void localeResolver() {
    }

    @Test
    public void postApi() {
    }
}