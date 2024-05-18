package com.se_b4.catchtable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CatchtableApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatchtableApplication.class, args);
    }
}
