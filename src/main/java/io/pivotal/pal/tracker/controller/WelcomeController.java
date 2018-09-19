package io.pivotal.pal.tracker.controller;

import io.pivotal.pal.tracker.config.WelcomeConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private String message;

    @Autowired
    private WelcomeConfiguration welcomeConfiguration;

    public WelcomeController() {
    }

    public WelcomeController(String message) {
        this.message = message;
    }

    @GetMapping("/")
    public String sayHello() {
        return message != null ? message : welcomeConfiguration.getMessage();
    }
}
