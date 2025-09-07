package com.scau.cookai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CookAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CookAiApplication.class, args);
        System.out.println("=================================");
        System.out.println("CookAI Backend Started Successfully!");
        System.out.println("API Documentation: http://localhost:8080/api");
        System.out.println("=================================");
    }

}
