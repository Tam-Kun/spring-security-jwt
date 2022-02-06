package com.example.myauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class MyAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyAuthenticationApplication.class, args);
    }

}
