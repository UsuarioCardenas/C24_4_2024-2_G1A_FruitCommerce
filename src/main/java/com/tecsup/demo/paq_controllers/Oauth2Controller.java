package com.tecsup.demo.paq_controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class Oauth2Controller {
    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hell OAuth2");
    }
}
