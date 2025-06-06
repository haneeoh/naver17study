package org.example.springgradlethyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("test.*")
public class SpringGradleThymeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGradleThymeApplication.class, args);
    }

}
