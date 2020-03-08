package com.asiewiera.jsonfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JsonFilesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonFilesApplication.class, args);
    }

}
