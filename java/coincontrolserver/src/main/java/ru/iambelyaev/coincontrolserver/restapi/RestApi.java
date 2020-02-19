package ru.iambelyaev.coincontolserver.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RestApi {

    public static void main(String[] args) {
        SpringApplication.run(RestApi.class, args);
    }

}
