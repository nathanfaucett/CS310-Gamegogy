package edu.jsu.mcis.gamegogy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebService {
    public static void start() {
        SpringApplication.run(SpringWebService.class, new String[0]);
    }
}
