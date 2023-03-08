package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("example")
    public ResponseEntity<String> read() {
        return ResponseEntity.ok("Hello, Spring Boot via GCP Cloud Runner!");
    }
}