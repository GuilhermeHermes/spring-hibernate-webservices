package org.example.estudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class EstudoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstudoApplication.class, args);
    }

}
