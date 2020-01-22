package org.luciano.vjezba7;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@SpringBootApplication
public class Vjezba7Application {

    public static void main(String[] args) {
        SpringApplication.run(Vjezba7Application.class, args);
    }

}
