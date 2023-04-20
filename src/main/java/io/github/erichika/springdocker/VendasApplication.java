package io.github.erichika.springdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApplication {

    @GetMapping("/")
    public String hello() {
        return "<h1>Hello from Docker</h1>";
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
